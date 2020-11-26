package Lieferanten.Shared;

import java.io.Serializable;
import java.util.Date;

public class OrderDTO implements Serializable {

    private long id;

    private String lenkertyp;

    private String material;

    private String schaltung;

    private String griff;

    private double price;

    private Date deliveryDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLenkertyp() {
        return lenkertyp;
    }

    public void setLenkertyp(String lenkertyp) {
        this.lenkertyp = lenkertyp;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSchaltung() {
        return schaltung;
    }

    public void setSchaltung(String schaltung) {
        this.schaltung = schaltung;
    }

    public String getGriff() {
        return griff;
    }

    public void setGriff(String griff) {
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