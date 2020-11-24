package Lieferanten.Controller;

import Lieferanten.Model.Entities.OrderDTO;
import Lieferanten.Service.LieferantenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LieferantenController {

    @PostMapping("/getOrderOfferFromSupplierOne")
    public OrderDTO getOrderOffer (@RequestBody OrderDTO configuration) {
        return LieferantenService.generateOffer(configuration);
    }
}
