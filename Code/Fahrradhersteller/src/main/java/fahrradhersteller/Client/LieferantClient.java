package fahrradhersteller.Client;


import com.fasterxml.jackson.databind.ObjectMapper;
import fahrradhersteller.Model.Entities.OrderDTO;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class LieferantClient {

    public static OrderDTO getOfferFromSuppliers(OrderDTO order) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest getHandleMaterials = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8081/getOrderOfferFromSupplierOne"))
                .timeout(Duration.ofSeconds(10))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(new ObjectMapper().writeValueAsString(order)))
                .build();

        return new ObjectMapper().readValue(client.send(getHandleMaterials,
                HttpResponse.BodyHandlers.ofString()).body(), OrderDTO.class);
    }



    public static void main(String[] args) {
        try {
            OrderDTO myOrder = new OrderDTO();
            myOrder = getOfferFromSuppliers(myOrder);
            System.out.println(myOrder.getDeliveryDate() + " " + myOrder.getPrice());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
