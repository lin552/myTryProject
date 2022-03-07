package ProxyPattern;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 糖果贩卖机
 */
public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {

    String location;
    int count = 0;
    State state;

    public GumballMachine(String location, int count) throws RemoteException {
        this.location = location;
        this.count = count;
    }

    public State getState() {
        return state;
    }

    public String getLocation() {
        return location;
    }

    public int getCount() {
        return count;
    }
}
