package rs.ac.uns.ftn.rezervacije.stranice.kupac.home;

import java.io.Serializable;

public class Kridencijali implements Serializable {

    public static String KORISNICKO_IME = "korisnickoIme";
    public static String LOZINKA = "lozinka";

    private static final long serialVersionUID = -3297269925695453590L;

    private String korisnickoIme;
    private String lozinka;

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
