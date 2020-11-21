package server;

import shared.FahrradConfigurationCommunication;
import shared.model.FahrradConfiguration;

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

        server.addConfigurationOrder(new FahrradConfiguration());
    }
}
