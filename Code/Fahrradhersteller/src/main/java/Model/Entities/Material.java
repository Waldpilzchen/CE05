package Model.Entities;

import Model.Entities.Enums.LenkertypEnum;
import Model.Entities.Enums.MaterialEnum;

import javax.persistence.*;

@Entity
public class Material {

    @Id
    @Enumerated(EnumType.STRING)
    private MaterialEnum materialEnum;
}
