//线程安全问题：死锁
public class Demo2 {
    static Object locker1 = new Object();
    static Object locker2 = new Object();

    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(()->{
           synchronized (locker1) {
               System.out.println("t1 线程拿到locker1");
               // 此处的 sleep 目的是让 t1 和 t2 确实都已经拿到各自的 locker1 和 locker2
               // 然后再进行后序操作.
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               synchronized (locker2) {
                   System.out.println("t2 线程拿到locker2");
               }
           }
        });
        Thread t2 = new Thread(()->{
           synchronized (locker2) {
               System.out.println("t2 线程拿到locker2");
               // 此处的 sleep 目的是让 t1 和 t2 确实都已经拿到各自的 locker1 和 locker2
               // 然后再进行后序操作.
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               synchronized (locker1) {
                   System.out.println("t1 线程拿到locker1");
               }
           }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
