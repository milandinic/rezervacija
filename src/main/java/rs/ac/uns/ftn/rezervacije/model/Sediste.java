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

    private static final long serialVersionUID = 1624768855800006595L;

    @NotNull
    @ManyToOne
    private Let let;

    @ManyToOne
    private Korisnik korisnik;

    private boolean placeno;

    @Enumerated(EnumType.STRING)
    private TipSedista tipSedista;

    private Date datumRezervacije;

    public Sediste() {
        super();
    }

    public Sediste(long id, Let let, Korisnik korisnik, boolean placeno) {
        super(id);
        this.let = let;
        this.korisnik = korisnik;
        this.placeno = placeno;
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

    public boolean isPlaceno() {
        return placeno;
    }

    public void setPlaceno(boolean placeno) {
        this.placeno = placeno;
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

}
