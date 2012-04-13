package rs.ac.uns.ftn.rezervacije.stranice.admin.avion;

import java.util.Iterator;
import java.util.List;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.spring.injection.annot.SpringBean;

import rs.ac.uns.ftn.rezervacije.RezervacijaSession;
import rs.ac.uns.ftn.rezervacije.model.Avion;
import rs.ac.uns.ftn.rezervacije.service.AvionService;
import rs.ac.uns.ftn.rezervacije.service.DataProvider;

public class AvionDataProvider extends DataProvider<Avion> {

    private static final long serialVersionUID = 1L;

    @SpringBean
    private AvionService aeroplaneService;

    public AvionDataProvider() {
        super();
        Injector.get().inject(this);
    }

    public Iterator<Avion> iterator(int first, int count) {
        List<Avion> listOfAvion = aeroplaneService.getAllByCompany(first, count, RezervacijaSession.getSession()
                .getKorisnik().getKompanija().getId());
        return listOfAvion.iterator();
    }

    public int size() {
        return aeroplaneService.countAllByKompanija(
                RezervacijaSession.getSession().getKorisnik().getKompanija().getId()).intValue();
    }

}
