import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        Store st = new Store(10);
        ExecutorService ex = Executors.newCachedThreadPool();

        Semaphore produSemaphore = new Semaphore(10);
        Semaphore conSemaphore = new Semaphore(0);

        for(int i = 0 ; i < 20 ; i++){
            ex.submit(new Producer(st , produSemaphore , conSemaphore));
        }
        
        for(int i = 0 ; i < 5 ; i++){
            ex.submit(new Consumer(st , produSemaphore , conSemaphore));
        }
    }
}
