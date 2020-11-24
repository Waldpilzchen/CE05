package fahrradhersteller.Model.Entities;

import fahrradhersteller.Model.Entities.Enums.SchaltungEnum;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SCHALTUNG")
public class Schaltung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "handlebar_gearshift")
    private SchaltungEnum schaltungEnum;

    @OneToMany(mappedBy = "schaltung", cascade = CascadeType.ALL)
    private List<Dependency> dependencies;

    @OneToMany(mappedBy = "schaltung", cascade = CascadeType.ALL)
    private List<Order> orders;

    public Schaltung() {
    }

    public Schaltung(SchaltungEnum schaltungEnum) {
        this.schaltungEnum = schaltungEnum;
    }

    public SchaltungEnum getSchaltungEnum() {
        return schaltungEnum;
    }
}
