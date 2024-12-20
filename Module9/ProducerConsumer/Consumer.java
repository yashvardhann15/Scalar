package ProducerConsumer;


import java.util.concurrent.Callable;

public class Consumer implements Callable<Void>{
    private Store st;
    
    public Consumer(Store sta){
        this.st = sta;
    }

    @Override
    public Void call() throws Exception{
        while(true){
            synchronized(st){
                if(st.getItems().size() > 0){
                    st.removeItem();
                }
            }
        }
    }
}
