package SingletonPattern;

/**
 * 懒汉式
 * 单例模式
 */
public class Singleton2 {

    private static Singleton2 instance;

    private Singleton2() {
    }

    //线程不安全
    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }

    //线程安全 但性能不太好
    public static synchronized Singleton2 getInstance1() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }

}
