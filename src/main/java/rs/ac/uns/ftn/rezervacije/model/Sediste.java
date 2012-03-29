package rs.ac.uns.ftn.rezervacije.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Sediste extends AbstractPersistable {

    public static final String TIP_SEDISTA = "tipSedista";
    public static final String CENA = "cena";

    private static final long serialVersionUID = 1624768855800006595L;

    @NotNull
    @ManyToOne
    private Let let;

    @ManyToOne
    private Korisnik korisnik;

    @Enumerated(EnumType.STRING)
    private TipSedista tipSedista;

    private Date datumRezervacije;

    private int cena;

    public Sediste() {
        super();
    }

    public Sediste(long id, Let let, Korisnik korisnik) {
        super(id);
        this.let = let;
        this.korisnik = korisnik;
        this.tipSedista = TipSedista.EKONOMSKO;
    }

    public Let getLet() {
        return let;
    }

    public void setLet(Let let) {
        this.let = let;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public TipSedista getTipSedista() {
        return tipSedista;
    }

    public void setTipSedista(TipSedista tipSedista) {
        this.tipSedista = tipSedista;
    }

    public Date getDatumRezervacije() {
        return datumRezervacije;
    }

    public void setDatumRezervacije(Date datumRezervacije) {
        this.datumRezervacije = datumRezervacije;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

}
