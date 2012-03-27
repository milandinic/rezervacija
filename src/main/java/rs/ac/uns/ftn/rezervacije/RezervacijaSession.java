package rs.ac.uns.ftn.rezervacije;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.h2.security.SHA256;

import rs.ac.uns.ftn.rezervacije.model.Korisnik;
import rs.ac.uns.ftn.rezervacije.model.TipKorisnika;
import rs.ac.uns.ftn.rezervacije.service.KorisnikService;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.home.Pretraga;

public class RezervacijaSession extends WebSession {

    private static final long serialVersionUID = 1100291551385046555L;

    private Pretraga pretraga = new Pretraga();
    private Korisnik korisnik;

    @SpringBean
    private KorisnikService korisnikService;

    public static RezervacijaSession getSession() {
        return (RezervacijaSession) WebSession.get();
    }

    public RezervacijaSession(Request request) {
        super(request);
        Injector.get().inject(this);
    }

    public boolean isLoggedIn() {
        return korisnik != null;
    }

    @Override
    public boolean authenticate(String username, String password) {
        byte[] encodedPass = SHA256.getKeyPasswordHash(username, password.toCharArray());

        korisnik = korisnikService.authenticate(username, new String(encodedPass));

        return korisnik != null;
    }

    public boolean authenticateAdmin(String username, String password) {
        byte[] encodedPass = SHA256.getKeyPasswordHash(username, password.toCharArray());

        Korisnik noviKorisnik = korisnikService.authenticate(username, new String(encodedPass));
        if (noviKorisnik != null && noviKorisnik.getTipKorisnika().equals(TipKorisnika.ADMINISTRATOR)) {
            korisnik = noviKorisnik;
            return true;
        }

        return false;
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
