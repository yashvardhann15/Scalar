
import java.util.concurrent.Callable;


public class Subtractor implements Callable<Void>{
    Count count;

    public Subtractor(Count count){
        this.count = count;
    }
    @Override
    public Void call() throws Exception{
        for(int i = 0 ; i < 1000 ; i++){
            count.subtract();
        }
        return null;
    }
}