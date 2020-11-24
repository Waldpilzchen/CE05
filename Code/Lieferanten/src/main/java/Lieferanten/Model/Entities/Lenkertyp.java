package Lieferanten.Model.Entities;

import Lieferanten.Model.Entities.Enums.LenkertypEnum;

import java.util.List;


public class Lenkertyp {


    private long id;


    private LenkertypEnum lenkertypEnum;

    private List<Dependency> dependencies;

    public Lenkertyp() {

    }

    public Lenkertyp(LenkertypEnum lenkertypEnum) {
        this.lenkertypEnum = lenkertypEnum;
    }

    public LenkertypEnum getLenkertypEnum() {
        return lenkertypEnum;
    }
}
