package rs.ac.uns.ftn.rezervacije.stranice.admin.korisnik;

import java.util.Iterator;
import java.util.List;

import rs.ac.uns.ftn.rezervacije.model.Korisnik;
import rs.ac.uns.ftn.rezervacije.service.DataProvider;
import rs.ac.uns.ftn.rezervacije.service.KorisnikService;
import rs.ac.uns.ftn.rezervacije.service.KorisnikServiceImpl;

public class KorisnikDataProvider extends DataProvider<Korisnik> {

    private static final long serialVersionUID = 1L;

    private final KorisnikService korisnikService = new KorisnikServiceImpl();

    public Iterator<Korisnik> iterator(int first, int count) {
        List<Korisnik> listOfKorisnik = korisnikService.getAll();
        return listOfKorisnik.iterator();
    }

    public int size() {
        return korisnikService.countAll();
    }

}
