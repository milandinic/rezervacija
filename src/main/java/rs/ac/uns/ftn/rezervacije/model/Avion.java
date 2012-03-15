package rs.ac.uns.ftn.rezervacije.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Avion extends AbstractPersistable {

    private static final long serialVersionUID = 1L;

    public static String KAPACITET = "kapacitet";
    public static String PROIZVODJAC = "proizvodjac";
    public static String MODEL = "model";

    @NotNull
    @ManyToOne
    private Kompanija kompanija;

    private Integer kapacitet;
    private String proizvodjac;
    private String model;

    public Avion() {
        super();
    }

    public Avion(long id, Kompanija kompanija, Integer kapacitet, String proizvodjac, String model) {
        super(id);
        this.kompanija = kompanija;
        this.kapacitet = kapacitet;
        this.proizvodjac = proizvodjac;
        this.model = model;
    }

    public Kompanija getKompanija() {
        return kompanija;
    }

    public void setKompanija(Kompanija kompanija) {
        this.kompanija = kompanija;
    }

    public Integer getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(Integer kapacitet) {
        this.kapacitet = kapacitet;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return kompanija.getNaziv() + " " + proizvodjac + " " + model;
    }
}
