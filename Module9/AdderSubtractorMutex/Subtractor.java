import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;


public class Subtractor implements Callable<Void>{
    Count count;
    Lock lock;

    public Subtractor(Count count, Lock lock){
        this.count = count;
        this.lock = lock;
    }
    @Override
    public Void call() throws Exception{
        for(int i = 0 ; i < 1000 ; i++){
            lock.lock();
            count.value -= 1;
            lock.unlock();
        }
        return null;
    }
}