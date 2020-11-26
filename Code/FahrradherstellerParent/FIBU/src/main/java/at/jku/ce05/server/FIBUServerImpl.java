package at.jku.ce05.server;

import at.jku.ce05.shared.FahrradConfigurationCommunication;
import at.jku.ce05.shared.OrderDTO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class FIBUServerImpl implements FahrradConfigurationCommunication {

    private static char SEPARATOR = ';';

    public void addConfigurationOrder(OrderDTO configuration) throws RemoteException {
        if (configuration == null) throw new IllegalArgumentException("Configuration cannot be null");

        ArrayList<String> values = new ArrayList<String>();


    }

    public FIBUServerImpl () throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
    }

    private void initializeFile() {
        try {
            File myObj = new File("fibu.csv");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                ArrayList<String> headLine = new ArrayList<String>();
                headLine.add("ID");
                headLine.add("Date");
                headLine.add("Cost");
                writeToFile(headLine);
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void writeToFile(ArrayList<String> values) {
        try {
            FileWriter myWriter = new FileWriter("fibu.csv");
            for (String value: values) {
                myWriter.write(value + SEPARATOR);
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
