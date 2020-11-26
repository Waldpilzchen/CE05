package at.jku.ce05.fahrradhersteller.Model.Entities;

import at.jku.ce05.fahrradhersteller.Model.Entities.Enums.MaterialEnum;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "material", cascade = CascadeType.ALL)
    private List<Dependency> dependencies;

    @OneToMany(mappedBy = "material", cascade = CascadeType.ALL)
    private List<Order> orders;

    public Material() {
    }

    public Material(MaterialEnum materialEnum) {
        this.materialEnum = materialEnum;
    }

    public MaterialEnum getMaterialEnum() {
        return materialEnum;
    }
}
