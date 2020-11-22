package fahrradhersteller.Model.Entities;

import fahrradhersteller.Model.Entities.Enums.GriffEnum;

import javax.persistence.*;

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

    public Griff() {

    }

    public Griff(GriffEnum griffEnum) {
        this.griffEnum = griffEnum;
    }

    public GriffEnum getGriffEnum() {
        return griffEnum;
    }
}
