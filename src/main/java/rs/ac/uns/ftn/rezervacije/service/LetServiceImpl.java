package rs.ac.uns.ftn.rezervacije.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.rezervacije.dao.AbstractDao;
import rs.ac.uns.ftn.rezervacije.dao.LetDao;
import rs.ac.uns.ftn.rezervacije.model.Let;

@Service
class LetServiceImpl extends ICRUDImpl<Let> implements LetService, Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private LetDao letDao;

    public LetServiceImpl() {
        super();
        // Avion avion = new AvionServiceImpl().getAll().get(0);
        // Avion avion2 = new AvionServiceImpl().getAll().get(1);
        // Avion avion3 = new AvionServiceImpl().getAll().get(2);
        // Aerodrom aerodrom = new AerodromServiceImpl().getAll().get(0);
        // Aerodrom aerodrom2 = new AerodromServiceImpl().getAll().get(1);
        // Aerodrom aerodrom3 = new AerodromServiceImpl().getAll().get(2);
        // list.add(new Let(1, aerodrom, aerodrom3, avion2, new Date()));
        // list.add(new Let(2, aerodrom2, aerodrom, avion, new Date()));
        // list.add(new Let(3, aerodrom, aerodrom3, avion3, new Date()));
    }

    @Override
    protected AbstractDao<Let> getDao() {
        return (AbstractDao<Let>) letDao;
    }

}
