package rs.ac.uns.ftn.rezervacije.stranice.admin.aerodrom;

import java.util.Iterator;
import java.util.List;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.spring.injection.annot.SpringBean;

import rs.ac.uns.ftn.rezervacije.model.Aerodrom;
import rs.ac.uns.ftn.rezervacije.service.AerodromService;
import rs.ac.uns.ftn.rezervacije.service.DataProvider;

public class AerodromDataProvider extends DataProvider<Aerodrom> {

    private static final long serialVersionUID = 1L;

    @SpringBean
    private AerodromService aeroplaneService;

    public AerodromDataProvider() {
        super();
        Injector.get().inject(this);
    }

    public Iterator<Aerodrom> iterator(int first, int count) {
        List<Aerodrom> listOfAerodrom = aeroplaneService.getAll();
        return listOfAerodrom.iterator();
    }

    public int size() {
        return aeroplaneService.countAll();
    }

}
