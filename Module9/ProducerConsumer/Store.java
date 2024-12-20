package ProducerConsumer;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private int maxSize;
    private List<Object> items;

    public Store(int maxSize) {
        this.maxSize = maxSize;
        this.items = new ArrayList<>();
    }

    public int getMaxSize() {
        return maxSize;
    }

    public List<Object> getItems() {
        return items;
    }

    public void addItem() {
        if (this.getItems().size() < this.getMaxSize()) {
            System.out.println("Producer production time, current size " + this.items.size());
            this.items.add(new Object());
        }
    }

    public void removeItem(){
        if(this.getItems().size() > 0){
            System.out.println("Consumer consuming time, current size " + this.items.size());
            this.items.remove(this.items.size() - 1);
        }
    }
}
