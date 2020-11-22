package fahrradhersteller.Model.Entities;

import fahrradhersteller.Model.Entities.Enums.MaterialEnum;

import javax.persistence.*;

@Entity
@Table(name = "MATERIAL")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "handlebar_material")
    private MaterialEnum materialEnum;

    public Material() {
    }

    public Material(MaterialEnum materialEnum) {
        this.materialEnum = materialEnum;
    }

    public MaterialEnum getMaterialEnum() {
        return materialEnum;
    }
}
