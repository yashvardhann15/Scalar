import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client{
    public static void main(String[] args) throws Exception{
        Count count = new Count();
        
        ExecutorService ex = Executors.newFixedThreadPool(2);

        Lock lock = new ReentrantLock();

        Adder adder = new Adder(count , lock);
        Subtractor subtractor = new Subtractor(count , lock);

        Future<Void> future1 = ex.submit(adder);
        Future<Void> future2 = ex.submit(subtractor);

        future1.get();
        future2.get();

        System.out.println(count.value);

        ex.shutdown();
    }
    
    

    
}
