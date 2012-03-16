package rs.ac.uns.ftn.rezervacije.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.rezervacije.dao.AerodromDao;
import rs.ac.uns.ftn.rezervacije.model.Aerodrom;

@Service
class AerodromServiceImpl implements AerodromService, Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private AerodromDao aerodromDao;

    public AerodromServiceImpl() {
        super();
        // new Aerodrom(1, "Nikola Tesla", "BEG", "Beograd").persist();
        // new Aerodrom(2, "Zanjice", "BEG", "Podgorica").persist();
        // new Aerodrom(3, "Schiphol", "SCH", "Amsterdam").persist();
    }

    public void create(Aerodrom object) {
        aerodromDao.persist(object);
    }

    public void deleteById(long id) {
    }

    public Aerodrom getById(long id) {
        return aerodromDao.findById(id);
    }

    @SuppressWarnings("unchecked")
    public List<Aerodrom> getAll() {
        return aerodromDao.findAll();
    }

    public int countAll() {
        return aerodromDao.countAll();
    }

    public void update(Aerodrom object) {
        // object.merge();
    }

}
