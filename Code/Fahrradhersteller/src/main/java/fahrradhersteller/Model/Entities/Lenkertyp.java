package fahrradhersteller.Model.Entities;

import fahrradhersteller.Model.Entities.Enums.LenkertypEnum;

import javax.persistence.*;

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

    public Lenkertyp() {

    }

    public Lenkertyp(LenkertypEnum lenkertypEnum) {
        this.lenkertypEnum = lenkertypEnum;
    }

    public LenkertypEnum getLenkertypEnum() {
        return lenkertypEnum;
    }
}
