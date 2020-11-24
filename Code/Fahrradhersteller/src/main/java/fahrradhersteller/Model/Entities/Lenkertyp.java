package fahrradhersteller.Model.Entities;

import fahrradhersteller.Model.Entities.Enums.LenkertypEnum;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "LENKERTYP")
public class Lenkertyp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "handlebar_type")
    private LenkertypEnum lenkertypEnum;

    @OneToMany(mappedBy = "lenkertyp", cascade = CascadeType.ALL)
    private List<Dependency> dependencies;

    @OneToMany(mappedBy = "lenkertyp", cascade = CascadeType.ALL)
    private List<Order> orders;

    public Lenkertyp() {

    }

    public Lenkertyp(LenkertypEnum lenkertypEnum) {
        this.lenkertypEnum = lenkertypEnum;
    }

    public LenkertypEnum getLenkertypEnum() {
        return lenkertypEnum;
    }
}
