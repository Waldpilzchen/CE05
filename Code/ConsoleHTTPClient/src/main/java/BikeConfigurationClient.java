import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BikeConfigurationClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        consoleCommunication();
    }

    private static void consoleCommunication() throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String read = "";

        HttpClient client = HttpClient.newHttpClient();

        boolean cancelConfig = false;

        ArrayList<String> configuration = new ArrayList<>();
        ArrayList<String> configOptions = new ArrayList<>();

        for (int i=0; i<4 && !cancelConfig; i++) {

            String configOption = getConfigOptions(client,i, configuration);
            configOptions = (ArrayList<String>) new ObjectMapper().readValue(configOption, List.class);
            printOptions(configOptions);

            String line = scanner.nextLine();
            try {
                int userInput = evaluateUserInput(line, configOptions.size());
                if (userInput == -1) {
                    cancelConfig = true;
                }
                else {
                    configuration.add(configOptions.get(userInput-1));
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println("Please enter a valid number!");
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        /*if (!cancelConfig) {

            HttpRequest configurationSendRequest = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/configuration?" + requestBody))
                    .build();
            HttpResponse<String> requestResult = client.send(configurationSendRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println();
            System.out.println(configurationResult.getConfiguration().toString());
            if (configurationResult.getResult() == ConfigurationResult.SUCCESS){
                System.out.println(configurationResult.toString());
            }
            else {
                System.out.println(configurationResult.toString());
                consoleCommunication(true);
            }
            System.out.println("\n");
        }*/
    }

    private static int evaluateUserInput(String input, int maxSize) {
        int number = Integer.parseInt(input);
        if (!(number <= maxSize && number >= 0)) throw new IllegalArgumentException("Invalid number!");
        if (number == 0) return -1;
        return number;
    }

    public static String getConfigOptions (HttpClient client, int roundNumber, List<String> values) throws IOException, InterruptedException {
        switch (roundNumber) {
            case 0: {
                HttpRequest getHandleBarTypes = HttpRequest.newBuilder()
                        .uri(URI.create("http://localhost:8080/getAvailableHandlebarTypes"))
                        .build();

                return client.send(getHandleBarTypes,
                        HttpResponse.BodyHandlers.ofString()).body();
            }
            case 1: {
                if (values.size() != 1) throw new IllegalArgumentException("Incorrect values size");
                HttpRequest getMaterial = HttpRequest.newBuilder()
                        .uri(URI.create("http://localhost:8080/getAvailableHandlebarMaterials/" + values.get(0)))
                        .timeout(Duration.ofSeconds(10))
                        .header("Content-Type", "application/json")
                        .POST(HttpRequest.BodyPublishers.noBody())
                        .build();

                return client.send(getMaterial,
                        HttpResponse.BodyHandlers.ofString()).body();
            }
            case 2: {
                if (values.size() != 2) throw new IllegalArgumentException("Incorrect values size");
                HttpRequest getMaterial = HttpRequest.newBuilder()
                        .uri(URI.create("http://localhost:8080/getAvailableHandlebarGearshifts/" + values.get(0) + "/" + values.get(1)))
                        .timeout(Duration.ofSeconds(10))
                        .header("Content-Type", "application/json")
                        .POST(HttpRequest.BodyPublishers.noBody())
                        .build();

                return client.send(getMaterial,
                        HttpResponse.BodyHandlers.ofString()).body();
            }
            case 3: {
                if (values.size() != 3) throw new IllegalArgumentException("Incorrect values size");
                HttpRequest getHandleMaterials = HttpRequest.newBuilder()
                        .uri(URI.create("http://localhost:8080/getAvailableHandleMaterials/" + values.get(0) + "/" + values.get(1) + "/" + values.get(2)))
                        .timeout(Duration.ofSeconds(10))
                        .header("Content-Type", "application/json")
                        .POST(HttpRequest.BodyPublishers.noBody())
                        .build();

                return client.send(getHandleMaterials,
                        HttpResponse.BodyHandlers.ofString()).body();
            }
            default: {
                throw new IllegalArgumentException("Cannot parse round number");
            }
        }
    }

    public static String sendOrder (HttpClient client, ArrayList<String> values) throws IOException, InterruptedException {
        if (values.size() != 4) throw new IllegalArgumentException("Incorrect list size, cannot send order");
        HttpRequest getHandleMaterials = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/getOrderConfirmation/" + values.get(0) + "/" + values.get(1) + "/" + values.get(2) + "/" + values.get(3)))
                .timeout(Duration.ofSeconds(10))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        return client.send(getHandleMaterials,
                HttpResponse.BodyHandlers.ofString()).body();
    }

    public static void printOptions (List<String> options) {
        System.out.println("Please choose one of the following options: ");
        for (int i=0; i<options.size(); i++) {
            System.out.println(i+1 + " " + options.get(i).substring(0, 1).toUpperCase() + options.get(i).substring(1).toLowerCase());
        }
    }
}
