package rs.ac.uns.ftn.rezervacije.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.rezervacije.model.Aerodrom;

@Service
class AerodromServiceImpl implements AerodromService, Serializable {

    private static final long serialVersionUID = 1L;

    private final List<Aerodrom> list = new ArrayList<Aerodrom>();

    public AerodromServiceImpl() {
        super();
        list.add(new Aerodrom(1, "Nikola Tesla", "BEG", "Beograd"));
        list.add(new Aerodrom(2, "Zanjice", "BEG", "Podgorica"));
        list.add(new Aerodrom(3, "Schiphol", "SCH", "Amsterdam"));
    }

    public void create(Aerodrom object) {
        // TODO Auto-generated method stub

    }

    public void deleteById(long id) {
        // TODO Auto-generated method stub

    }

    public Aerodrom getById(long id) {
        return list.get(0);
    }

    public List<Aerodrom> getAll() {
        return list;
    }

    public int countAll() {
        return list.size();
    }

    public void update(Aerodrom object) {
        // TODO Auto-generated method stub

    }

}
