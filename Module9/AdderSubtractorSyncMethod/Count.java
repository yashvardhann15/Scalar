public class Count {
        int value = 0;

        public synchronized void add(){
                this.value += 1;
        }

        public synchronized void subtract(){
                this.value -= 1;
        }
}
