import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;

public class Producer implements Callable<Void>{
    private Store st;
    private Semaphore pSemaphore;
    private Semaphore cSemaphore;
    


    public Producer(Store st , Semaphore produSemaphore , Semaphore conSemaphore){
        this.st = st;
        this.pSemaphore = produSemaphore;
        this.cSemaphore = conSemaphore;
    }

    @Override
    public Void call() throws Exception{
        while(true){
            pSemaphore.acquire();
            st.addItem();
            cSemaphore.release();
        }
    }
}