class MyBlockingQueue{
    private String[] array = null;
    private int size = 0;
    private int head = 0;
    private int tail = 0;

    private Object locker = new Object();

    public MyBlockingQueue(int capacity){
        array = new String[capacity];
    }
    public void put(String elem) throws InterruptedException {
        synchronized (locker){
            while (size >= array.length){
                locker.wait();
            }
            array[tail++] = elem;
            if (tail >= array.length){
                tail = 0;
            }
            size++;
            locker.notify();
        }
    }
    public String take() throws InterruptedException {
        synchronized (locker){
            while (size == 0){
                locker.wait();
            }
           String result = array[head++];
            if (head >= array.length){
                head = 0;
            }
            size--;
            locker.notify();
            return result;
        }
    }

}
public class Main {
    public static void main(String[] args) {
        // 基于自己的阻塞队列, 也实现一个生产者消费者模型.
        MyBlockingQueue queue = new MyBlockingQueue(1000);

        Thread producer = new Thread(() -> {
            int count = 0;
            try {
                while (true) {
                    queue.put("" + count);
                    System.out.println("生产了一个元素: " + count);
                    count++;
                    // Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    String elem = queue.take();
                    System.out.println("消费了一个元素: " + elem);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        producer.start();
        consumer.start();
    }
}
