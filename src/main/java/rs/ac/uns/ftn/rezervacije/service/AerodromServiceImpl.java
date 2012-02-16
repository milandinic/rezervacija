package rs.ac.uns.ftn.rezervacije.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.ftn.rezervacije.model.Aerodrom;

public class AerodromServiceImpl implements AerodromService, Serializable {

    private static final long serialVersionUID = 1L;

    private final List<Aerodrom> list = new ArrayList<Aerodrom>();

    public AerodromServiceImpl() {
        super();
        list.add(new Aerodrom("BG", 1L));
        list.add(new Aerodrom("PG", 2L));
        list.add(new Aerodrom("SC", 3L));
    }

    public void create(Aerodrom object) {
        // TODO Auto-generated method stub

    }

    public void deleteById(long id) {
        // TODO Auto-generated method stub

    }

    public Aerodrom getById(long id) {
        return new Aerodrom("Boing 741", id);
    }

    public List<Aerodrom> getAll() {
        return list;
    }

    public int countAll() {
        return list.size();
    }

}
