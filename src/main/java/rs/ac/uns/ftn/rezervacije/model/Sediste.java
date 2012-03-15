package rs.ac.uns.ftn.rezervacije.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Sediste extends AbstractPersistable {

    private static final long serialVersionUID = 1624768855800006595L;

    @NotNull
    @ManyToOne
    private Let let;

    @NotNull
    @ManyToOne
    private Korisnik korisnik;
    private boolean placeno;

    public Sediste() {
        super();
    }

    public Sediste(long id, Let let, Korisnik korisnik, boolean placeno) {
        super(id);
        this.let = let;
        this.korisnik = korisnik;
        this.placeno = placeno;
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

}
