package at.jku.ce05.fahrradhersteller.Model;

import at.jku.ce05.fahrradhersteller.Model.Entities.Order;
import at.jku.ce05.shared.OrderDTO;

public class Service {

    public static OrderDTO convertToOrderDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setLenkertyp(order.getLenkertyp().getLenkertypEnum().name());
        orderDTO.setMaterial(order.getMaterial().getMaterialEnum().name());
        orderDTO.setSchaltung(order.getSchaltung().getSchaltungEnum().name());
        orderDTO.setGriff(order.getGriff().getGriffEnum().name());
        orderDTO.setPrice(order.getPrice());
        orderDTO.setDeliveryDate(order.getDeliveryDate());
        return orderDTO;
    }

    /*public Order convertToOrder(OrderDTO orderDTO) {

    }*/
}
