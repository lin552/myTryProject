package FacadePattern;

/**
 * CD 播放机
 */
public class CdPlayer {
    Amplifier amplifier;

    public CdPlayer(Amplifier amplifier) {
        this.amplifier = amplifier;
    }

    void on() {
        System.out.println("CD播放机 打开");
    }

    void off() {
        System.out.println("CD播放机 关闭");
    }

    void eject() {
        System.out.println("CD播放机 弹出");
    }
    void pause() {
        System.out.println("CD播放机 暂停");
    }
    void play() {
        System.out.println("CD播放器 播放");
    }
    void stop() {
        System.out.println("CD播放器 停止");
    }

    @Override
    public String toString() {
        return "CdPlayer{" +
                "amplifier=" + amplifier +
                '}';
    }
}
