package rs.ac.uns.ftn.rezervacije.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.rezervacije.dao.AbstractDao;
import rs.ac.uns.ftn.rezervacije.dao.AerodromDao;
import rs.ac.uns.ftn.rezervacije.model.Aerodrom;

@Service
class AerodromServiceImpl extends ICRUDImpl<Aerodrom> implements AerodromService, Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private AerodromDao aerodromDao;

    @Override
    protected AbstractDao<Aerodrom> getDao() {
        return aerodromDao;
    }

}
