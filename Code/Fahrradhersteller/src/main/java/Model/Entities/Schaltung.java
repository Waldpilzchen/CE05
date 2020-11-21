package Model.Entities;

import Model.Entities.Enums.LenkertypEnum;
import Model.Entities.Enums.SchaltungEnum;

import javax.persistence.*;

@Entity
public class Schaltung {

    @Id
    @Enumerated(EnumType.STRING)
    private SchaltungEnum schaltungEnum;
}
