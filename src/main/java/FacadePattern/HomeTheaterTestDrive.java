package FacadePattern;

/**
 * 外观模式
 * 测试
 */
public class HomeTheaterTestDrive {
    public static void main(String[] args) {

        Amplifier amplifier = new Amplifier();
        Tuner tuner = new Tuner();
        DvdPlayer dvdPlayer = new DvdPlayer(amplifier);
        CdPlayer cdPlayer = new CdPlayer(amplifier);
        Projector projector = new Projector(dvdPlayer);
        PopcornPopper popcornPopper = new PopcornPopper();
        TheaterLights theaterLights = new TheaterLights();
        Screen screen = new Screen();

        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(amplifier, tuner, dvdPlayer, cdPlayer, projector, popcornPopper, theaterLights, screen);

        homeTheaterFacade.watchMovie("Raiders of ht Lost Ark");
        homeTheaterFacade.endMovie();

    }
}
