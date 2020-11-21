package server;

import shared.FahrradConfigurationCommunication;
import shared.model.FIBUStatus;
import shared.model.FahrradConfiguration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class FIBUServerImpl implements FahrradConfigurationCommunication {

    private static char SEPARATOR = ';';

    public FIBUServerImpl() throws RemoteException {
        UnicastRemoteObject.exportObject(this,0);
        this.initializeFile();
    }

    @Override
    public FIBUStatus addConfigurationOrder(FahrradConfiguration configuration) throws RemoteException {
        if (configuration == null) return FIBUStatus.FAILURE;

        //Write configuration to fibu.csv file

        return FIBUStatus.SUCCESS;
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
