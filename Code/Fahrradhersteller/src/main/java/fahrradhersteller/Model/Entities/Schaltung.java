package fahrradhersteller.Model.Entities;

import fahrradhersteller.Model.Entities.Enums.SchaltungEnum;

import javax.persistence.*;

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

    public Schaltung() {
    }

    public Schaltung(SchaltungEnum schaltungEnum) {
        this.schaltungEnum = schaltungEnum;
    }

    public SchaltungEnum getSchaltungEnum() {
        return schaltungEnum;
    }
}
