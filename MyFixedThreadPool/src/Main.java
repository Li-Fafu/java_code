import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class MyFixedThreadPool {
    private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();

    public MyFixedThreadPool(int n) {
        for (int i = 0; i < n; i++) {
            //创建线程
            Thread t = new Thread(() -> {
                //每个线程要完成的工作：从任务队列取出任务然后执行
                try{
                    while(true){
                        Runnable task = queue.take();
                        task.run();
                    }
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
            t.start();
        }
    }
    public void submit(Runnable task) throws InterruptedException {
        queue.put(task);
    }
}

public class Main {
    public static void main (String[] args) throws InterruptedException {
        MyFixedThreadPool threadPool = new MyFixedThreadPool(4);
        for (int i = 0; i < 100; i++){
            int id = i;
            threadPool.submit(()->{
                System.out.println("执行任务：" + id);
            });
        }
    }
}
