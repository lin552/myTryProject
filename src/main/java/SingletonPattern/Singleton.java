package SingletonPattern;


/**
 * 双重检查加锁
 * 单例模式
 *
 * 经验之谈：一般情况下，
 * 不建议使用第 1 种和第 2 种懒汉方式，建议使用第 3 种饿汉方式。
 * 只有在要明确实现 lazy loading 效果时，才会使用第 5 种登记方式。如果涉及到反序列化创建对象时，可以尝试使用第 6 种枚举方式。
 * 如果有其他特殊的需求，可以考虑使用第 4 种双检锁方式。
 */
public class Singleton {

    private volatile static Singleton uniqueInstance;

    //把构造方法私有化
    private Singleton() {

    }

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            //如果实例不存在就进入同步区块
            synchronized (Singleton.class) {
                //进入同步区块再检查一次，如果为空才创造实例
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
