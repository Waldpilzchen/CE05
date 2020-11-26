package at.jku.ce05.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FahrradConfigurationCommunication extends Remote {
    void addConfigurationOrder (OrderDTO configuration) throws RemoteException;
}
