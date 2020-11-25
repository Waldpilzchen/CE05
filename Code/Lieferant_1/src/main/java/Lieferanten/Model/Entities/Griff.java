package Lieferanten.Model.Entities;

import Lieferanten.Model.Entities.Enums.GriffEnum;

import java.util.List;


public class Griff {

    private long id;

    private GriffEnum griffEnum;

    private List<Dependency> dependencies;

    public Griff() {

    }

    public Griff(GriffEnum griffEnum) {
        this.griffEnum = griffEnum;
    }

    public GriffEnum getGriffEnum() {
        return griffEnum;
    }
}
