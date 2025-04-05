//饿汉模式
//类加载的同时创建实例.

class SingletonLazy{
    private static volatile SingletonLazy instance = null;
    private static Object locker = new Object();

    // 第一次使用这个实例的时候, 才会创建这个实例. 创建时机是更晚的.
    public static SingletonLazy getInstance() {
        if (instance == null) {
            synchronized (locker) {
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
}
public class HungerSweat {
    public static void main(String[] args) {
        SingletonLazy s1 = SingletonLazy.getInstance();
        SingletonLazy s2 = SingletonLazy.getInstance();
        System.out.println(s1 == s2); // true
    }
}

