import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ImagePainter implements Callable<Void> {
    private String[][] matrix;
    private int startRow, endRow, startCol, endCol;
    private String color;
    private ExecutorService executor;

    public ImagePainter(String[][] matrix, int startRow, int endRow, int startCol, int endCol, String color, ExecutorService executor) {
        this.matrix = matrix;
        this.startRow = startRow;
        this.endRow = endRow;
        this.startCol = startCol;
        this.endCol = endCol;
        this.color = color;
        this.executor = executor;
    }

    @Override
    public Void call() throws Exception {
        for (int row = startRow; row < endRow; row++) {
            for (int col = startCol; col < endCol; col++) {
                matrix[row][col] = color;
            }
        }
        return null;
    }

    public static void divideAndPaint(String[][] matrix, String[] colors) throws Exception {
        int midRow = matrix.length / 2;
        int midCol = matrix[0].length / 2;

        int[][] topLeft = { { 0, midRow }, { 0, midCol } };
        int[][] topRight = { { 0, midRow }, { midCol, matrix[0].length } };
        int[][] bottomLeft = { { midRow, matrix.length }, { 0, midCol } };
        int[][] bottomRight = { { midRow, matrix.length }, { midCol, matrix[0].length } };

        int[][][] quadrants = { topLeft, topRight, bottomLeft, bottomRight };

        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Future<Void>> futures = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int startRow = quadrants[i][0][0];
            int endRow = quadrants[i][0][1];
            int startCol = quadrants[i][1][0];
            int endCol = quadrants[i][1][1];
            String color = colors[i];

            ImagePainter task = new ImagePainter(matrix, startRow, endRow, startCol, endCol, color, executor);
            futures.add(executor.submit(task));
        }

        for (Future<Void> future : futures) {
            future.get();
        }

        executor.shutdown();
    }
}

