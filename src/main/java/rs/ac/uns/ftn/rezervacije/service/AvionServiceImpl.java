package rs.ac.uns.ftn.rezervacije.service;

import java.io.Serializable;
import java.util.List;

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

    public List<Avion> getAllByCompany(int first, int count, Long kompanijaId) {
        return avionDao.getAllByCompany(first, count, kompanijaId);
    }

    public Long countAllByKompanija(Long kompanijaId) {
        return avionDao.countAllByKompanija(kompanijaId);
    }

}
