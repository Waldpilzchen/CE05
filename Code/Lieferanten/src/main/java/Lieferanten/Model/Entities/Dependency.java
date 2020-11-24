package Lieferanten.Model.Entities;

public class Dependency {

    private long id;

    private Lenkertyp lenkertyp;

    private Material material;

    private Schaltung schaltung;

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
