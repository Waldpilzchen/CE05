package at.jku.ce05.fahrradhersteller.Model.Entities;

import at.jku.ce05.fahrradhersteller.Model.Entities.Enums.GriffEnum;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "GRIFF")
public class Griff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "handle_material")
    private GriffEnum griffEnum;

    @OneToMany(mappedBy = "griff", cascade = CascadeType.ALL)
    private List<Dependency> dependencies;

    @OneToMany(mappedBy = "griff", cascade = CascadeType.ALL)
    private List<Order> orders;

    public Griff() {

    }

    public Griff(GriffEnum griffEnum) {
        this.griffEnum = griffEnum;
    }

    public GriffEnum getGriffEnum() {
        return griffEnum;
    }
}
