package fahrradhersteller.Model.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lenkertyp lenkertyp;

    @ManyToOne(fetch = FetchType.LAZY)
    private Material material;

    @ManyToOne(fetch = FetchType.LAZY)
    private Schaltung schaltung;

    @ManyToOne(fetch = FetchType.LAZY)
    private Griff griff;

    @Column(name = "price")
    private double price;

    @Column(name = "delivery_date")
    private Date deliveryDate;

}
