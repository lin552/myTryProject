package FacadePattern;

/**
 * 调谐器
 */
public class Tuner {
    Amplifier amplifier;

    void  on() {
        System.out.println("调谐器 打开");
    }
    void  off() {
        System.out.println("调谐器 关闭");

    }
    void setAm() {
        System.out.println("调谐器 设置AM");

    }
    void setFm() {
        System.out.println("调谐器 设置FM");

    }
    void setFrequency() {
        System.out.println("调谐器 设置频率");

    }

    @Override
    public String toString() {
        return "Tuner{" +
                "amplifier=" + amplifier +
                '}';
    }
}
