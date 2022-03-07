package FacadePattern;

/**
 * 投影仪
 */
public class Projector {
    DvdPlayer dvdPlayer;

    public Projector(DvdPlayer dvdPlayer) {
        this.dvdPlayer = dvdPlayer;
    }

    void on() {
        System.out.println("投影仪 打开");
    }
    void off() {
        System.out.println("投影仪 关闭");

    }
    void tvMode() {
        System.out.println("投影仪 电视模式");
    }
    void wideScreenMode() {
        System.out.println("投影仪 剧场模式");
    }

    @Override
    public String toString() {
        return "Project{" +
                "dvdPlayer=" + dvdPlayer +
                '}';
    }
}
