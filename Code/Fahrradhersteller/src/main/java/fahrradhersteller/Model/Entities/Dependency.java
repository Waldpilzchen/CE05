package fahrradhersteller.Model.Entities;

import javax.persistence.*;

@Entity
@Table(name = "DEPENDENCIES")
public class Dependency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lenkertyp lenkertyp;

    @ManyToOne(fetch = FetchType.LAZY)
    private Material material;

    @ManyToOne(fetch = FetchType.LAZY)
    private Schaltung schaltung;

    @ManyToOne(fetch = FetchType.LAZY)
    private Griff griff;

    public Dependency() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Lenkertyp getLenkertyp() {
        return lenkertyp;
    }

    public void setLenkertyp(Lenkertyp lenkertyp) {
        this.lenkertyp = lenkertyp;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Schaltung getSchaltung() {
        return schaltung;
    }

    public void setSchaltung(Schaltung schaltung) {
        this.schaltung = schaltung;
    }

    public Griff getGriff() {
        return griff;
    }

    public void setGriff(Griff griff) {
        this.griff = griff;
    }
}
