// 自己实现的定时器.
// 定时器要能够同时管理多个任务.
// 有一定的数据结构来组织这多个任务.
// ArrayList 不太合适
// 更好的选择是优先级队列.

import java.util.PriorityQueue;

//因为要按照时间顺序来存放入优先级队列，所以要指定”比较规则“
class MyTimerTask implements Comparable<MyTimerTask> {
    private Runnable task;
    private long time;
    public MyTimerTask(Runnable task, long delay){
        this.task = task;

        //这里记录的时间是“绝对的时间戳”
        this.time = System.currentTimeMillis() + delay;
    }

    public Runnable getTask() {
        return task;
    }

    public long getTime() {
        return time;
    }

    @Override
    public int compareTo(MyTimerTask o) {
        return (int)(this.time - o.time);
    }
}

class MyTimer{
    private PriorityQueue<MyTimerTask> queue = new PriorityQueue<MyTimerTask>();
    private Object locker = new Object();

    public MyTimer(){
        //创建线程，当时间到了，就会自动执行任务
        Thread t = new Thread(()->{
            while(true){
               try{
                   synchronized(locker){
                       while(queue.isEmpty()){
                           locker.wait();
                       }
                       MyTimerTask task = queue.peek();
                       //获取当前的时间戳
                       long curtime = System.currentTimeMillis();
                       if(curtime < task.getTime()){
                           //时间还没到
                           locker.wait(task.getTime() - curtime);
                       } else{
                           //时间到了
                           task.getTask().run();
                           queue.poll();
                       }
                   }
               } catch(InterruptedException e){
                   e.printStackTrace();
               }
            }
        });
        t.start();
    }
    public void schedule(Runnable runnable, long delay){
        synchronized(locker){
            queue.offer(new MyTimerTask(runnable, delay));
            locker.notify();
        }
    }

}

public class Main {
    public static void main(String[] args) {
        MyTimer timer = new MyTimer();
        System.out.println("程序开始！");
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("定时任务 3000");
            }
        }, 3000);

        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("定时任务 2000");
            }
        }, 2000);

        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("定时任务 1000");
            }
        }, 1000);
    }
}
