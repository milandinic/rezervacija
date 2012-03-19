package rs.ac.uns.ftn.rezervacije.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.rezervacije.dao.AbstractDao;
import rs.ac.uns.ftn.rezervacije.dao.AvionDao;
import rs.ac.uns.ftn.rezervacije.model.Avion;

@Service
class AvionServiceImpl extends ICRUDImpl<Avion> implements AvionService, Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private AvionDao avionDao;

    public AvionServiceImpl() {
        super();
        // Kompanija kompanija = new Kompanija();
        // kompanija.setId(0L);
        // kompanija.setNaziv("Jat");
        // list.add(new Avion(1, kompanija, 100, "boing", "474"));
        // list.add(new Avion(2, kompanija, 200, "boing", "999"));
        // list.add(new Avion(3, kompanija, 100, "boing", "474"));
    }

    @Override
    protected AbstractDao<Avion> getDao() {
        return avionDao;
    }

}
