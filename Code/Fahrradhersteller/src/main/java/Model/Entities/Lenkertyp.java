package Model.Entities;

import Model.Entities.Enums.LenkertypEnum;

import javax.persistence.*;

@Entity
public class Lenkertyp {

    @Id
    @Enumerated(EnumType.STRING)
    private LenkertypEnum lenkertypEnum;
}
