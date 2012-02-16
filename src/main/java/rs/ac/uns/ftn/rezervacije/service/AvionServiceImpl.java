package rs.ac.uns.ftn.rezervacije.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.ftn.rezervacije.model.Avion;

public class AvionServiceImpl implements AvionService, Serializable {

    private static final long serialVersionUID = 1L;

    private final List<Avion> list = new ArrayList<Avion>();

    public AvionServiceImpl() {
        super();
        list.add(new Avion(100, "Boing 741", 1L));
        list.add(new Avion(50, "Boing 742", 2L));
        list.add(new Avion(10, "Boing 747", 3L));
    }

    public void create(Avion object) {
        // TODO Auto-generated method stub

    }

    public void deleteById(long id) {
        // TODO Auto-generated method stub

    }

    public Avion getById(long id) {
        return new Avion(100, "Boing 741", id);
    }

    public List<Avion> getAll() {
        return list;
    }

    public int countAll() {
        return list.size();
    }

}
