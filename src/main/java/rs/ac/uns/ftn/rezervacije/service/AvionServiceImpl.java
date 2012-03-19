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

    @Override
    protected AbstractDao<Avion> getDao() {
        return avionDao;
    }

}
