package rs.ac.uns.ftn.rezervacije.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.rezervacije.model.Aerodrom;
import rs.ac.uns.ftn.rezervacije.model.Avion;
import rs.ac.uns.ftn.rezervacije.model.Let;

@Service
class LetServiceImpl implements LetService, Serializable {

    private static final long serialVersionUID = 1L;

    private final List<Let> list = new ArrayList<Let>();

    public LetServiceImpl() {
        super();
        Avion avion = new AvionServiceImpl().getAll().get(0);
        Avion avion2 = new AvionServiceImpl().getAll().get(1);
        Avion avion3 = new AvionServiceImpl().getAll().get(2);
        Aerodrom aerodrom = new AerodromServiceImpl().getAll().get(0);
        Aerodrom aerodrom2 = new AerodromServiceImpl().getAll().get(1);
        Aerodrom aerodrom3 = new AerodromServiceImpl().getAll().get(2);
        list.add(new Let(1, aerodrom, aerodrom3, avion2, new Date()));
        list.add(new Let(2, aerodrom2, aerodrom, avion, new Date()));
        list.add(new Let(3, aerodrom, aerodrom3, avion3, new Date()));
    }

    public void create(Let object) {
        // TODO Auto-generated method stub

    }

    public void deleteById(long id) {
        // TODO Auto-generated method stub

    }

    public Let getById(long id) {
        return list.get(0);
    }

    public List<Let> getAll() {
        return list;
    }

    public int countAll() {
        return list.size();
    }

    public void update(Let object) {
        // TODO Auto-generated method stub

    }

}
