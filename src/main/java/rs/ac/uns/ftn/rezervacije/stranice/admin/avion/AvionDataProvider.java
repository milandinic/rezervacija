package rs.ac.uns.ftn.rezervacije.stranice.admin.avion;

import java.util.Iterator;
import java.util.List;

import rs.ac.uns.ftn.rezervacije.model.Avion;
import rs.ac.uns.ftn.rezervacije.service.AeroplaneService;
import rs.ac.uns.ftn.rezervacije.service.AeroplaneServiceImpl;
import rs.ac.uns.ftn.rezervacije.service.DataProvider;

public class AvionDataProvider extends DataProvider<Avion> {

    private static final long serialVersionUID = 1L;

    private final AeroplaneService aeroplaneService = new AeroplaneServiceImpl();

    public Iterator iterator(int first, int count) {
        List<Avion> listOfAvion = aeroplaneService.getListOfAvion();
        return listOfAvion.iterator();
    }

    public int size() {
        return aeroplaneService.getListOfAvionSize();
    }

}
