package rs.ac.uns.ftn.rezervacije.model;

import javax.persistence.Entity;

@Entity
public class Kompanija extends AbstractPersistable {

    private static final long serialVersionUID = 4421683943458192748L;

    private String naziv;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

}
