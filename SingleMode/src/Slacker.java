//懒汉模式-单线程版
//类加载的时候不创建实例.第⼀次使⽤的时候才创建实例


class Singleton{
    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

    // 把构造方法设置为 private, 此时就无法在类的外部来 new 了.
    private Singleton() {

    }
}
public class Slacker {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2); // true
    }
}
