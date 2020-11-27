package at.jku.ce05.server;

import at.jku.ce05.shared.FahrradConfigurationCommunication;
import at.jku.ce05.shared.OrderDTO;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.OffsetDateTime;
import java.util.ArrayList;

public class FIBUServerImpl implements FahrradConfigurationCommunication {

    private static char SEPARATOR = ';';

    public void addConfigurationOrder(OrderDTO configuration) throws RemoteException {
        if (configuration == null) throw new IllegalArgumentException("Configuration cannot be null");

        ArrayList<String> values = new ArrayList<String>();
        values.add(String.valueOf(configuration.getId()));
        values.add(configuration.getLenkertyp());
        values.add(configuration.getMaterial());
        values.add(configuration.getSchaltung());
        values.add(configuration.getGriff());
        values.add(String.valueOf(configuration.getPrice()));
        values.add(configuration.getDeliveryDate().toString());
        values.add(OffsetDateTime.now().toString());
        writeToFile(values);
    }

    public FIBUServerImpl () throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        this.initializeFile();
    }

    private void initializeFile() {
        try {
            File myObj = new File("fibu.csv");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                ArrayList<String> headLine = new ArrayList<String>();
                headLine.add("ID");
                headLine.add("Lenkertyp");
                headLine.add("Material");
                headLine.add("Schaltung");
                headLine.add("Griff");
                headLine.add("Preis");
                headLine.add("Lieferdatum");
                headLine.add("Bestelldatum");
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
        try (FileWriter myWriter = new FileWriter("fibu.csv", true);
             BufferedWriter bw = new BufferedWriter(myWriter);
             PrintWriter pw = new PrintWriter(bw)){

            for (String value: values) {
                pw.print(value + SEPARATOR);
            }
            pw.println();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
