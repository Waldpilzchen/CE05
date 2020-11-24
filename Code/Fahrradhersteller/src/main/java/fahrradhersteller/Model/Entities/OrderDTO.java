package fahrradhersteller.Model.Entities;

import java.util.Date;

public class OrderDTO {

    private long id;

    private Lenkertyp lenkertyp;

    private Material material;

    private Schaltung schaltung;

    private Griff griff;

    private double price;

    private Date deliveryDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Lenkertyp getLenkertyp() {
        return lenkertyp;
    }

    public void setLenkertyp(Lenkertyp lenkertyp) {
        this.lenkertyp = lenkertyp;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Schaltung getSchaltung() {
        return schaltung;
    }

    public void setSchaltung(Schaltung schaltung) {
        this.schaltung = schaltung;
    }

    public Griff getGriff() {
        return griff;
    }

    public void setGriff(Griff griff) {
        this.griff = griff;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void convertOrderToDTO(Order order) {
        setId(order.getId());
        setLenkertyp(order.getLenkertyp());
        setMaterial(order.getMaterial());
        setSchaltung(order.getSchaltung());
        setGriff(order.getGriff());
        setPrice(order.getPrice());
        setDeliveryDate(order.getDeliveryDate());
    }

    public OrderDTO evaluateOffer(OrderDTO other) {
        int dateChoice = this.getDeliveryDate().compareTo(other.deliveryDate);
        switch(dateChoice) {
            //this Datum davor z.B. 2001.compareTo(2002) = -1
            case -1: {
                if(this.getPrice() == other.getPrice())
                    return this;
                else if(this.getPrice() < other.getPrice())
                    return this;
                //this Datum davor aber this Preis größer
                else {
                    //wie viele Tage ist this vor other
                    long diffDays = (other.getDeliveryDate().getTime() - this.getDeliveryDate().getTime()) / (60 * 60 * 1000 * 24);
                    //wenn this min. 5 tage vor other ist und this max. 300€ teuer als other ist
                    if (diffDays >= 5 && (this.getPrice() - other.getPrice()) <= 300) {
                        return this;
                    } else
                        return other;
                }
            }
            //other Datum davor
            case 1: {
                if(this.getPrice() == other.getPrice())
                    return this;
                else if(this.getPrice() > other.getPrice())
                    return other;
                //other Datum davor aber other Preis größer
                else {
                    //wie viele Tage ist other vor this
                    long diffDays = (this.getDeliveryDate().getTime() - other.getDeliveryDate().getTime()) / (60 * 60 * 1000 * 24);
                    //wenn other min. 5 tage vor this ist und other max. 300€ teuer als this ist
                    if (diffDays >= 5 && (other.getPrice() - this.getPrice()) <= 300) {
                        return other;
                    } else
                        return this;
                }
            }
            //this Datum gleich
            default: {
                if(this.getPrice() == other.getPrice())
                    return this;
                else if(this.getPrice() < other.getPrice())
                    return this;
                else
                    return other;
            }
        }
    }
}