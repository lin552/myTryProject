package FacadePattern;

/**
 * DVD 播放器
 */
public class DvdPlayer {
    Amplifier amplifier;

    public DvdPlayer(Amplifier amplifier) {
        this.amplifier = amplifier;
    }

    void on() {
        System.out.println("DVD播放器 打开");
    }
    void  off() {
        System.out.println("DVD播放器 关闭");
    }
    void eject() {
        System.out.println("DVD播放器 弹出");
    }
    void pause() {
        System.out.println("DVD播放器 暂停");
    }
    void play(String movie) {
        System.out.println("DVD播放器 播放");
    }
    void setSurroundAudio() {
        System.out.println("DVD播放器 设置环绕声");
    }
    void setTwoChannelAudio() {
        System.out.println("DVD播放器 设置双声道");
    }
    void stop() {
        System.out.println("DVD播放器 停止");
    }
}
