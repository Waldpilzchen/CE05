package shared;

import shared.model.FIBUStatus;
import shared.model.FahrradConfiguration;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FahrradConfigurationCommunication extends Remote {
    FIBUStatus addConfigurationOrder (FahrradConfiguration configuration) throws RemoteException;
}
