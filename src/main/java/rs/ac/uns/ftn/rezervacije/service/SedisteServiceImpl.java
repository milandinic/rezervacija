package rs.ac.uns.ftn.rezervacije.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.rezervacije.model.Sediste;

@Service
class SedisteServiceImpl implements SedisteService, Serializable {

    private static final long serialVersionUID = 1L;

    private final List<Sediste> list = new ArrayList<Sediste>();

    public SedisteServiceImpl() {
        super();
        // Avion avion = new AvionServiceImpl().getAll().get(0);
        // Avion avion2 = new AvionServiceImpl().getAll().get(1);
        // Avion avion3 = new AvionServiceImpl().getAll().get(2);
        // Aerodrom aerodrom = new AerodromServiceImpl().getAll().get(0);
        // Aerodrom aerodrom2 = new AerodromServiceImpl().getAll().get(1);
        // Aerodrom aerodrom3 = new AerodromServiceImpl().getAll().get(2);
        // Let let1 = new Let(1, aerodrom, aerodrom3, avion2, new Date());
        // Let let2 = new Let(2, aerodrom2, aerodrom, avion, new Date());
        // Let let3 = new Let(3, aerodrom, aerodrom3, avion3, new Date());
        //
        // list.add(new Sediste(1, let1, null, false));
        // list.add(new Sediste(2, let2, null, false));
        // list.add(new Sediste(3, let3, null, false));
    }

    public void create(Sediste object) {
        // TODO Auto-generated method stub

    }

    public void deleteById(long id) {
        // TODO Auto-generated method stub

    }

    public Sediste getById(long id) {
        return list.get(0);
    }

    public List<Sediste> getAll() {
        return list;
    }

    public int countAll() {
        return list.size();
    }

    public void update(Sediste object) {
        // TODO Auto-generated method stub

    }

}
