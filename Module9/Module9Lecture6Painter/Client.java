public class Client {
    public static void main(String[] args) throws Exception {
        String[][] matrix = {
            { "0", "0", "0", "0" },
            { "0", "0", "0", "0" },
            { "0", "0", "0", "0" },
            { "0", "0", "0", "0" }
        };

        String[] colors = { "red", "blue", "green", "yellow" };

        ImagePainter.divideAndPaint(matrix, colors);

        for (String[] row : matrix) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}