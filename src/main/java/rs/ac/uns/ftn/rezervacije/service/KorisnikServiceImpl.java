package rs.ac.uns.ftn.rezervacije.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.rezervacije.dao.BaseDao;
import rs.ac.uns.ftn.rezervacije.dao.KorisnikDao;
import rs.ac.uns.ftn.rezervacije.model.Korisnik;

@Service
class KorisnikServiceImpl extends ICRUDImpl<Korisnik> implements KorisnikService, Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private KorisnikDao korisnikDao;

    public KorisnikServiceImpl() {
        super();
        // list.add(new Korisnik(1, "Pera", "Peric", "a", "a"));
        // list.add(new Korisnik(2, "Ana", "Anic", "b", "b"));
        // list.add(new Korisnik(3, "Ceda", "Cedic", "c", "c"));
    }

    @SuppressWarnings("unchecked")
    @Override
    protected BaseDao<Korisnik> getDao() {
        return (BaseDao<Korisnik>) korisnikDao;
    }

}
