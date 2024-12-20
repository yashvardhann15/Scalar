import java.util.concurrent.ConcurrentLinkedDeque;

public class Store {
    
    private int maxSize;
    private ConcurrentLinkedDeque<Object> items;

    public Store(int size){
        this.maxSize = size;
        this.items = new ConcurrentLinkedDeque<>();
    }

    public int getMaxSize(){
        return maxSize;
    }

    public ConcurrentLinkedDeque<Object> getItems(){
        return items;
    }

    public Void addItem(){
        this.items.add(new Object());
        System.out.println("Producer production time, current size " + this.items.size());
        return null;
    }

    public Void removeItem(){
        this.items.remove();
        System.out.println("Consumer consuming time, current size " + this.items.size());
        return null;
    }
}
