package rs.ac.uns.ftn.rezervacije.stranice.kupac.istorija;

import java.util.Iterator;
import java.util.List;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.spring.injection.annot.SpringBean;

import rs.ac.uns.ftn.rezervacije.RezervacijaSession;
import rs.ac.uns.ftn.rezervacije.model.Sediste;
import rs.ac.uns.ftn.rezervacije.service.DataProvider;
import rs.ac.uns.ftn.rezervacije.service.SedisteService;

public class IstorijaProvider extends DataProvider<Sediste> {

    private static final long serialVersionUID = 1L;

    @SpringBean
    private SedisteService sedisteService;

    public IstorijaProvider() {
        super();
        Injector.get().inject(this);
    }

    public Iterator<Sediste> iterator(int first, int count) {
        List<Sediste> listOfSedsite = sedisteService.findByKorisnik(RezervacijaSession.getSession().getKorisnik(),
                first, count);
        return listOfSedsite.iterator();
    }

    public int size() {
        return sedisteService.countByKorisnik(RezervacijaSession.getSession().getKorisnik());
    }

}
