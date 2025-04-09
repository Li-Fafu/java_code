//内存可见性
public class Demo3 {
    static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while(flag){

            }
        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("休眠结束");
            flag = false;
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
