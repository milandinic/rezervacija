package rs.ac.uns.ftn.rezervacije.stranice.kupac.rezervacija;

import java.util.Iterator;

import rs.ac.uns.ftn.rezervacije.RezervacijaSession;
import rs.ac.uns.ftn.rezervacije.model.Sediste;
import rs.ac.uns.ftn.rezervacije.service.DataProvider;

public class SedistaDataProvider extends DataProvider<Sediste> {

    private static final long serialVersionUID = 1L;

    public Iterator<Sediste> iterator(int first, int count) {
        return RezervacijaSession.getSession().getRezultat().iterator();
    }

    public int size() {
        return RezervacijaSession.getSession().getRezultat().size();
    }

}
