import java.util.concurrent.Callable;

public class Adder implements  Callable<Void>{
    Count count;

    public Adder(Count count){
        this.count = count;
    }

    public Void call() throws Exception{
        for(int i = 0 ; i < 1000 ; i++){
            synchronized(count){
                count.value += 1;
            }
        }
        return null;
    }
}
