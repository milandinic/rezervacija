package rs.ac.uns.ftn.rezervacije.stranice.admin.aerodrom;

import java.util.Iterator;
import java.util.List;

import rs.ac.uns.ftn.rezervacije.model.Aerodrom;
import rs.ac.uns.ftn.rezervacije.service.AerodromService;
import rs.ac.uns.ftn.rezervacije.service.AerodromServiceImpl;
import rs.ac.uns.ftn.rezervacije.service.DataProvider;

public class AerodromDataProvider extends DataProvider<Aerodrom> {

    private static final long serialVersionUID = 1L;

    private final AerodromService aeroplaneService = new AerodromServiceImpl();

    public Iterator<Aerodrom> iterator(int first, int count) {
        List<Aerodrom> listOfAerodrom = aeroplaneService.getAll();
        return listOfAerodrom.iterator();
    }

    public int size() {
        return aeroplaneService.countAll();
    }

}
