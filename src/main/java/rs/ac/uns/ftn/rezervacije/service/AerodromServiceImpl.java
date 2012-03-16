package rs.ac.uns.ftn.rezervacije.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.rezervacije.dao.AerodromDao;
import rs.ac.uns.ftn.rezervacije.dao.BaseDao;
import rs.ac.uns.ftn.rezervacije.model.Aerodrom;

@Service
class AerodromServiceImpl extends ICRUDImpl<Aerodrom> implements AerodromService, Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private AerodromDao aerodromDao;

    public AerodromServiceImpl() {
        super();
        // new Aerodrom(1, "Nikola Tesla", "BEG", "Beograd").persist();
        // new Aerodrom(2, "Zanjice", "BEG", "Podgorica").persist();
        // new Aerodrom(3, "Schiphol", "SCH", "Amsterdam").persist();
    }

    @SuppressWarnings("unchecked")
    @Override
    protected BaseDao<Aerodrom> getDao() {
        return ((BaseDao<Aerodrom>) aerodromDao);
    }

}
