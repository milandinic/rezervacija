package rs.ac.uns.ftn.rezervacije.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import org.h2.security.SHA256;

@Entity
public class Korisnik extends AbstractPersistable {

    public static final String TIP = "tipKorisnika";
    public static final String IME = "ime";
    public static final String PREZIME = "prezime";
    public static final String LOZINKA = "lozinka";
    public static final String KORISNICKO_IME = "korisnickoIme";

    private static final long serialVersionUID = 7205369385038938219L;

    private String ime;
    private String prezime;

    private String korisnickoIme;
    private String lozinka;

    @Enumerated(EnumType.STRING)
    private TipKorisnika tipKorisnika;

    @ManyToOne
    private Kompanija kompanija;

    public Korisnik() {
        super();
    }

    public Korisnik(long id, String ime, String prezime, String korisnickoIme, String lozinka) {
        super(id);
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        byte[] encodedPass = SHA256.getKeyPasswordHash(korisnickoIme, lozinka.toCharArray());
        this.lozinka = new String(encodedPass);
        this.tipKorisnika = TipKorisnika.KUPAC;
    }

    public Korisnik(long id, String ime, String prezime, String korisnickoIme, String lozinka, Kompanija kompanija) {
        super(id);
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        byte[] encodedPass = SHA256.getKeyPasswordHash(korisnickoIme, lozinka.toCharArray());
        this.lozinka = new String(encodedPass);
        this.tipKorisnika = TipKorisnika.ADMINISTRATOR;
        this.kompanija = kompanija;
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

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Kompanija getKompanija() {
        return kompanija;
    }

    public void setKompanija(Kompanija kompanija) {
        this.kompanija = kompanija;
    }

    @Override
    public String toString() {
        return ime;
    }
}
