package Model.Entities;

import Model.Entities.Enums.GriffEnum;
import Model.Entities.Enums.LenkertypEnum;

import javax.persistence.*;

@Entity
public class Griff {

    @Id
    @Enumerated(EnumType.STRING)
    private GriffEnum griffEnum;
}
