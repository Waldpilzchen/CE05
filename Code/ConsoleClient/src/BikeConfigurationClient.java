import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

public class BikeConfigurationClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        consoleCommunication();
    }

    private static void consoleCommunication() throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String read = "";

        HttpClient client = HttpClient.newHttpClient();
        /*HttpRequest getMaxRounds = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/maxrounds"))
                .build();

        HttpResponse<String> response = client.send(getMaxRounds,
                HttpResponse.BodyHandlers.ofString());

        int maxRoundNumber = Integer.parseInt(response.body()); */
        boolean cancelConfig = false;

        ArrayList<String> configuration = new ArrayList<>();

        for (int i=0; i<5 && !cancelConfig; i++) {

            String configOption = getConfigOptions(client,i);
            System.out.println(configOption);

            String line = scanner.nextLine();
            try {
                int userInput = evaluateUserInput(line, i);
                if (userInput == -1) {
                    cancelConfig = true;
                }
                else {
                    configuration.add(mapToString(userInput, userInput));
                }
                i++;
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
        // TODO Change max number to list size
        if (!(number < maxSize && number >= 0)) throw new IllegalArgumentException("Invalid number!");
        if (number == 0) return -1;
        return number;
    }

    public static String mapToString (Object inputs, int number) {
        // TODO adapt number to corresponding string
        return "TestString";
    }

    public static String getConfigOptions (HttpClient client, int roundNumber) throws IOException, InterruptedException {
        switch (roundNumber) {
            case 0: {
                HttpRequest getMaxRounds = HttpRequest.newBuilder()
                        .uri(URI.create("http://localhost:8080/getAvailableHandlebarTypes"))
                        .build();

                return client.send(getMaxRounds,
                        HttpResponse.BodyHandlers.ofString()).body();
            }
            case 1: {
                // TODO getAvailableHandlebarMaterials/{auswahl des lenkertyps} - POST
                return "";
            }
            case 2: {
                // TODO getAvailableHandlebarGearshifts/{asuwhal des lenkertyps}/{auswahl des materials} - POST
                return "";
            }
            case 3: {
                // TODO getAvailableHandleMaterials/{auswahl des lenkertyps}/{auswahl des materials}/{auswhal der schaltung} - POST
                return "";
            }
            default: {
                throw new IllegalArgumentException("Cannot parse round number");
            }
        }
    }

    public static void sendOrder (ArrayList<String> values) {
        // TODO getOrderConfirmation/{auswahl des lenkertyps/{auswahl des materials}/{auswahl der schaltung}/{auswahl des griffs} - POST

    }
}
