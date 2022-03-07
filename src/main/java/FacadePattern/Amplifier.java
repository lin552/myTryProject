package FacadePattern;

/**
 * 扩音器
 */
public class Amplifier {
    Tuner tuner;
    DvdPlayer dvdPlayer;
    CdPlayer cdPlayer;

    void on() {
        System.out.println("扩音器 打开");
    }

    void off() {
        System.out.println("扩音器 关闭");

    }
    void Cd() {
        System.out.println("扩音器 播放CD");
    }

    void setDvd(DvdPlayer dvdPlayer) {
        System.out.println("扩音器 设置DVD播放器");

    }
    void setStereoSound() {
        System.out.println("扩音器 设置立体声");

    }

    void setSurroundSound() {
        System.out.println("扩音器 设置环绕声");

    }

    void setTuner(Tuner tuner) {
        System.out.println("扩音器 设置调谐器");

    }

    void setVolume(int volume) {
        System.out.println("扩音器 设置音量");

    }

    @Override
    public String toString() {
        return "Amplifier{" +
                "tuner=" + tuner +
                ", dvdPlayer=" + dvdPlayer +
                ", cdPlayer=" + cdPlayer +
                '}';
    }
}
