package rs.ac.uns.ftn.rezervacije.stranice.admin.korisnik;

import java.util.Iterator;
import java.util.List;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.spring.injection.annot.SpringBean;

import rs.ac.uns.ftn.rezervacije.model.Korisnik;
import rs.ac.uns.ftn.rezervacije.service.DataProvider;
import rs.ac.uns.ftn.rezervacije.service.KorisnikService;

public class KorisnikDataProvider extends DataProvider<Korisnik> {

    private static final long serialVersionUID = 1L;

    @SpringBean
    private KorisnikService korisnikService;

    public KorisnikDataProvider() {
        super();
        Injector.get().inject(this);
    }

    public Iterator<Korisnik> iterator(int first, int count) {
        List<Korisnik> listOfKorisnik = korisnikService.getAll();
        return listOfKorisnik.iterator();
    }

    public int size() {
        return korisnikService.countAll();
    }

}
