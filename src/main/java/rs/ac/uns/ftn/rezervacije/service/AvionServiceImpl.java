package rs.ac.uns.ftn.rezervacije.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.rezervacije.model.Avion;

@Service
class AvionServiceImpl implements AvionService, Serializable {

    private static final long serialVersionUID = 1L;

    private final List<Avion> list = new ArrayList<Avion>();

    public AvionServiceImpl() {
        super();
        // Kompanija kompanija = new Kompanija();
        // kompanija.setId(0L);
        // kompanija.setNaziv("Jat");
        // list.add(new Avion(1, kompanija, 100, "boing", "474"));
        // list.add(new Avion(2, kompanija, 200, "boing", "999"));
        // list.add(new Avion(3, kompanija, 100, "boing", "474"));
    }

    public void create(Avion object) {
        // TODO Auto-generated method stub

    }

    public void deleteById(long id) {
        // TODO Auto-generated method stub

    }

    public Avion getById(long id) {
        return list.get(0);
    }

    public List<Avion> getAll() {
        return list;
    }

    public int countAll() {
        return list.size();
    }

    public void update(Avion object) {
        // TODO Auto-generated method stub

    }

}
