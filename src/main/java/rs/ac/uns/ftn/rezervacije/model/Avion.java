package rs.ac.uns.ftn.rezervacije.model;

public class Avion extends AbstractPersistable {

    private static final long serialVersionUID = 1L;

    public static String KAPACITET = "kapacitet";
    public static String NAZIV = "naziv";

    private Integer kapacitet;
    private String naziv;

    public Avion() {
        super();
    }

    public Avion(Integer kapacitet, String naziv, Long id) {
        super(id);
        this.kapacitet = kapacitet;
        this.naziv = naziv;
    }

    public Integer getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(Integer kapacitet) {
        this.kapacitet = kapacitet;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

}
