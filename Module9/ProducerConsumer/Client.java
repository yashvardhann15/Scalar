package ProducerConsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newCachedThreadPool();

        Store st = new Store(5);

        for(int i = 1 ; i <= 20 ; i++){
            ex.submit(new Producer(st));
        }

        for(int i = 1 ; i <= 10 ; i++){
            ex.submit(new Consumer(st));
        }
    }
}
