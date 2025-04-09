import java.util.Random;

public class Demo3 {
  private static final Object lock1 = new Object();
  private static final Object lock2 = new Object();
  private static final Random random = new Random();

  public static void main(String[] args) throws InterruptedException{
    Thread t1 = new Thread(() -> {
      while (true) {
        synchronized (lock1) {
          System.out.println("线程A获得lock1");
          if (random.nextBoolean()) {
            System.out.println("线程A尝试获取lock2...");
            synchronized (lock2) {
              System.out.println("线程A成功获得两个锁");
            }
          } else {
            System.out.println("线程A释放lock1重试");
            try {
              Thread.sleep(random.nextInt(100));
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
      }
    });
  
    Thread t2 = new Thread(() -> {
      while (true) {
        synchronized (lock2) {
          System.out.println("线程B获得lock2");
          if (random.nextBoolean()) {
            System.out.println("线程B尝试获取lock1...");
            synchronized (lock1) {
              System.out.println("线程B成功获得两个锁");
            }
          } else {
            System.out.println("线程B释放lock2重试");
            try {
              Thread.sleep(random.nextInt(100));
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
      }
    });
    t1.start();
    t2.start();
    t1.join();
    t2.join();
  }

}
