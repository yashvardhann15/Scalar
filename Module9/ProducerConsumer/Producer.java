package ProducerConsumer;


import java.util.concurrent.Callable;

public class Producer implements Callable<Void>{
    private Store st;

    public Producer(Store st){
        this.st = st;
    }

    @Override
    public Void call() throws Exception{
        while(true){
            synchronized(st){
                if(st.getItems().size() < st.getMaxSize())
                st.addItem();
            }
        }
    }
}
