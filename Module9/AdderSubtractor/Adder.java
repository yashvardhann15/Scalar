import java.util.concurrent.Callable;

public class Adder implements  Callable<Void>{
    Count count;

    public Adder(Count count){
        this.count = count;
    }
    @Override
    public Void call() throws Exception{
        for(int i = 0 ; i < 1000 ; i++){
            count.value += 1;
        }
        return null;
    }
}
