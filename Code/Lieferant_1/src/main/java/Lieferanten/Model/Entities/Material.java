package Lieferanten.Model.Entities;

import Lieferanten.Model.Entities.Enums.MaterialEnum;

import java.util.List;

public class Material {

    private long id;

    private MaterialEnum materialEnum;

    private List<Dependency> dependencies;

    public Material() {
    }

    public Material(MaterialEnum materialEnum) {
        this.materialEnum = materialEnum;
    }

    public MaterialEnum getMaterialEnum() {
        return materialEnum;
    }
}
