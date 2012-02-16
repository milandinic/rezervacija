package rs.ac.uns.ftn.rezervacije.stranice.admin.avion;

import java.util.Iterator;
import java.util.List;

import rs.ac.uns.ftn.rezervacije.model.Avion;
import rs.ac.uns.ftn.rezervacije.service.AvionService;
import rs.ac.uns.ftn.rezervacije.service.AvionServiceImpl;
import rs.ac.uns.ftn.rezervacije.service.DataProvider;

public class AvionDataProvider extends DataProvider<Avion> {

    private static final long serialVersionUID = 1L;

    private final AvionService aeroplaneService = new AvionServiceImpl();

    public Iterator<Avion> iterator(int first, int count) {
        List<Avion> listOfAvion = aeroplaneService.getAll();
        return listOfAvion.iterator();
    }

    public int size() {
        return aeroplaneService.countAll();
    }

}
