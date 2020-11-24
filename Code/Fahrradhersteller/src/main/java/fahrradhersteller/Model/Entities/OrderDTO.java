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
}