package rs.ac.uns.ftn.rezervacije.model;

public class Aerodrom extends AbstractPersistable {

    private static final long serialVersionUID = -946405757513011563L;

    public static final String NAZIV = "naziv";

    private String naziv;

    public Aerodrom() {
        super();
    }

    public Aerodrom(String naziv, Long id) {
        super(id);
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

}
