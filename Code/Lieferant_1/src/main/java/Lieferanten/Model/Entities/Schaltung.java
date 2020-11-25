package Lieferanten.Model.Entities;

import Lieferanten.Model.Entities.Enums.SchaltungEnum;

import java.util.List;

public class Schaltung {

    private long id;

    private SchaltungEnum schaltungEnum;

    private List<Dependency> dependencies;

    public Schaltung() {
    }

    public Schaltung(SchaltungEnum schaltungEnum) {
        this.schaltungEnum = schaltungEnum;
    }

    public SchaltungEnum getSchaltungEnum() {
        return schaltungEnum;
    }
}
