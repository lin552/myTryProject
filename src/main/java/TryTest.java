import CommandPattern.Light;
import CommandPattern.LightOnCommand;
import CommandPattern.SimpleRemoteControl;
import DecoratorPattern.*;
import FactoryPattern.ChicagoStore;
import FactoryPattern.NYPizzaStore;
import FactoryPattern.Pizza;
import FactoryPattern.PizzaStore;
import se.vidstige.jadb.JadbConnection;
import se.vidstige.jadb.JadbDevice;
import se.vidstige.jadb.JadbException;
import se.vidstige.jadb.managers.PackageManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TryTest {

    public static void main(String[] args) throws JadbException, IOException {
//        testReadStringFromConsole();
//        coffeeTest();
//        InputTest();
//        PizzaTest();
        LightCommandTest();
    }

    public static void PizzaTest() {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoStore();

        Pizza pizza = nyStore.orderPizza("chess");
        System.out.println("Ethan order a " + pizza.getName() + "\n");

        Pizza pizza1 = chicagoStore.orderPizza("chess");
        System.out.println("Joel order a " + pizza1.getName() + "\n");
    }

    public static void LightCommandTest() {
        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
        Light light = new Light();
        //实例化命令对象
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        //设置命令
        simpleRemoteControl.setCommand(lightOnCommand);
        //按下按钮
        simpleRemoteControl.buttonWasPressed();
    }

    public static void InputTest() throws IOException {
        int c;
        InputStream in = new LowerCaseInputStream(new BufferedInputStream(
                new FileInputStream("test.txt")
        ));

        while ((c = in.read()) >= 0) {
            System.out.println((char) c);
        }

    }

    public static void coffeeTest() {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + "$" + beverage.cost());

        Beverage beverage1 = new HouseBlend();
        beverage1 = new Mocha(beverage1);
        System.out.println(beverage1.getDescription() + "$" + beverage1.cost());

    }

    public void testListToArray() {
        List<String> lists = new ArrayList<>();

        lists.add("1");
        lists.add("2");
        lists.add("3");
        lists.add("4");
        lists.add("5");

        String[] objects = lists.toArray(new String[0]);


        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
    }

    public static void testReadStringFromConsole() throws IOException, JadbException, JadbException {
        JadbConnection jadb = new JadbConnection();
        List<JadbDevice> devices = jadb.getDevices();
        JadbDevice jadbDevice = devices.get(0);
        PackageManager packageManager = new PackageManager(jadbDevice);
//        packageManager.install();
    }
}
