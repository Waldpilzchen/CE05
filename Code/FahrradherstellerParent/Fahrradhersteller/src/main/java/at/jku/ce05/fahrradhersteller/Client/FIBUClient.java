package at.jku.ce05.fahrradhersteller.Client;

import at.jku.ce05.shared.FahrradConfigurationCommunication;
import at.jku.ce05.shared.OrderDTO;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Date;

public class FIBUClient {
    FahrradConfigurationCommunication server;

    public FIBUClient () {}

    public void startClient() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        server = (FahrradConfigurationCommunication)registry.lookup("FIBUServer");
    }

    public void addConfigurationOrder (OrderDTO configuration) throws RemoteException, NotBoundException {
        if (server == null) throw new NotBoundException("Client has not been initialized");
        server.addConfigurationOrder(configuration);
    }


    /**
     * This method is just to test the rmi connection. Can be deleted in the final version
     * @param args
     */
    public static void main(String[] args) throws RemoteException, NotBoundException {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setDeliveryDate(Date.valueOf("2011-01-05"));
        orderDTO.setGriff("");
        orderDTO.setId(3);
        orderDTO.setLenkertyp("");
        orderDTO.setMaterial("");
        orderDTO.setPrice(450);
        orderDTO.setSchaltung("");

        FIBUClient fibuClient = new FIBUClient();
        fibuClient.startClient();
        fibuClient.addConfigurationOrder(orderDTO);
    }
}
