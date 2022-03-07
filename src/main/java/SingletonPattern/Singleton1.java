package SingletonPattern;

/**
 * 使用"急切"创建实例 -- 饿汉式
 * 单例模式
 * 类加载时就初始化，浪费内存
 */
public class Singleton1 {
    //JVM保证在任何线程访问时，一定先创建此实例
    private static Singleton1 uniqueInstance = new Singleton1();

    //构造方法私有
    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        return uniqueInstance;
    }

}
