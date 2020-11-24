package Lieferanten.Service;

import Lieferanten.Model.Entities.OrderDTO;

import java.sql.Date;
import java.util.Random;

public class LieferantenService {
    private static final Random RAND = new Random();
    private static final Double MIN_PREIS = 750.00;
    private static final Double MAX_PREIS = 1500.00;

    public static OrderDTO generateOffer (OrderDTO configuration) {
        configuration.setPrice(MIN_PREIS + (MAX_PREIS-MIN_PREIS) * RAND.nextDouble());
        configuration.setDeliveryDate(Date.valueOf("2021-" + (RAND.nextInt(12) + 1) + "-" + (RAND.nextInt(28) + 1) ));
        return configuration;
    }

    /**
     * This is just a test function, can be deleted in the final version
     * @param args
     */
    public static void main(String[] args) {
        OrderDTO configuration = new OrderDTO();
        generateOffer(configuration);
        System.out.println(configuration.getPrice() + " " + configuration.getDeliveryDate());
    }
}
