import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;

public class Consumer implements Callable<Void>{
    private Store st;
    private Semaphore pSemaphore, cSemaphore;

    public Consumer(Store st , Semaphore produSemaphore , Semaphore conSemaphore){
        this.st  = st;
        this.pSemaphore = produSemaphore;
        this.cSemaphore = conSemaphore;
    }

    @Override
    public Void call() throws Exception{
        while(true){
            cSemaphore.acquire();
            st.removeItem();
            pSemaphore.release();
        }
    }
}