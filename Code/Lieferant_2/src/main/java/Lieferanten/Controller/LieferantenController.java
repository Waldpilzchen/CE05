package Lieferanten.Controller;

import Lieferanten.Service.LieferantenService;
import Lieferanten.Shared.OrderDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LieferantenController {

    @PostMapping("/getOrderOfferFromSupplierTwo")
    public OrderDTO getOrderOffer (@RequestBody OrderDTO configuration) {
        return LieferantenService.generateOffer(configuration);
    }
}
