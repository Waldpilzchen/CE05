package at.jku.ce05.server;

import at.jku.ce05.shared.FahrradConfigurationCommunication;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class FIBUConfigurationRunServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        FahrradConfigurationCommunication server = new FIBUServerImpl();
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("FIBUServer", server);
        System.out.println("Server started");
    }
}
