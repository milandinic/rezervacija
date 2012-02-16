package rs.ac.uns.ftn.rezervacije.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.ftn.rezervacije.model.Avion;

public class AeroplaneServiceImpl implements AeroplaneService, Serializable {

    private static final long serialVersionUID = 1L;

    private final List<Avion> list = new ArrayList<Avion>();

    public AeroplaneServiceImpl() {
        super();
        list.add(new Avion(100, "Boing 741", 1L));
        list.add(new Avion(50, "Boing 742", 2L));
        list.add(new Avion(10, "Boing 747", 3L));
    }

    public List<Avion> getListOfAvion() {
        return list;
    }

    public int getListOfAvionSize() {
        return list.size();
    }

}
