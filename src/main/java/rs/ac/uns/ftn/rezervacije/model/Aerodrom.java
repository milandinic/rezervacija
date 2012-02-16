package rs.ac.uns.ftn.rezervacije.model;

public class Aerodrom extends AbstractPersistable {

    private static final long serialVersionUID = -946405757513011563L;

    private String naziv;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

}
