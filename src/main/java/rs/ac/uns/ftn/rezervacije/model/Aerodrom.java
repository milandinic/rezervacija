package rs.ac.uns.ftn.rezervacije.model;

import javax.persistence.Entity;

@Entity
public class Aerodrom extends AbstractPersistable {

    private static final long serialVersionUID = -946405757513011563L;

    public static final String NAZIV = "naziv";
    public static final String SIFRA = "sifra";
    public static final String MESTO = "mesto";

    private String naziv;
    private String sifra;
    private String mesto;

    public Aerodrom() {
        super();
    }

    public Aerodrom(long id) {
        super(id);
    }

    public Aerodrom(long id, String naziv, String sifra, String mesto) {
        super(id);
        this.naziv = naziv;
        this.sifra = sifra;
        this.mesto = mesto;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    @Override
    public String toString() {
        return naziv;
    }

}
