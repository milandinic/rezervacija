package rs.ac.uns.ftn.rezervacije.model;

public class Korisnik extends AbstractPersistable {

    public static final String TIP = "tipKorisnika";
    public static final String IME = "korisnickoIme";
    public static final String LOZINKA = "ime";
    public static final String KORISNICKO_IME = "ime";

    private static final long serialVersionUID = 7205369385038938219L;

    private String ime;

    private String korisnickoIme;
    private String lozinka;
    private TipKorisnika tipKorisnika;

    public Korisnik() {
        super();
    }

    public Korisnik(String ime, String korisnickoIme, String lozinka, Long id) {
        super(id);
        this.ime = ime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.tipKorisnika = TipKorisnika.KUPAC;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public TipKorisnika getTipKorisnika() {
        return tipKorisnika;
    }

    public void setTipKorisnika(TipKorisnika tipKorisnika) {
        this.tipKorisnika = tipKorisnika;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

}
