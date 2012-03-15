package rs.ac.uns.ftn.rezervacije;

import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

import rs.ac.uns.ftn.rezervacije.model.Korisnik;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.home.Pretraga;

public class RezervacijaSession extends WebSession {

    private static final long serialVersionUID = 1100291551385046555L;

    private Pretraga pretraga = new Pretraga();
    private Korisnik korisnik;

    public static RezervacijaSession getSession() {
        return (RezervacijaSession) WebSession.get();
    }

    public RezervacijaSession(Request request) {
        super(request);
    }

    public void setPretraga(Pretraga pretraga) {
        this.pretraga = pretraga;
    }

    public Pretraga getPretraga() {
        return pretraga;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

}
