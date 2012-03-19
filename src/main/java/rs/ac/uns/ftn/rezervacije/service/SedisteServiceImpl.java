package rs.ac.uns.ftn.rezervacije.service;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.rezervacije.dao.AbstractDao;
import rs.ac.uns.ftn.rezervacije.dao.AerodromDao;
import rs.ac.uns.ftn.rezervacije.dao.AvionDao;
import rs.ac.uns.ftn.rezervacije.dao.KompanijaDao;
import rs.ac.uns.ftn.rezervacije.dao.KorisnikDao;
import rs.ac.uns.ftn.rezervacije.dao.SedisteDao;
import rs.ac.uns.ftn.rezervacije.model.Aerodrom;
import rs.ac.uns.ftn.rezervacije.model.Avion;
import rs.ac.uns.ftn.rezervacije.model.Kompanija;
import rs.ac.uns.ftn.rezervacije.model.Korisnik;
import rs.ac.uns.ftn.rezervacije.model.Sediste;

@Service
class SedisteServiceImpl extends ICRUDImpl<Sediste> implements SedisteService, Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private SedisteDao sedisteDao;

    @Autowired
    private KompanijaDao kompanijaDao;

    @Autowired
    private AvionDao avionDao;

    @Autowired
    private AerodromDao aerodromDao;

    @Autowired
    private KorisnikDao korisnikDao;

    public SedisteServiceImpl() {
        super();

    }

    @PostConstruct
    void demo() {
        Kompanija kompanija = new Kompanija();
        kompanija.setId(0L);
        kompanija.setNaziv("Jat");

        kompanijaDao.persist(kompanija);

        avionDao.persist(new Avion(1, kompanija, 100, "boing", "474"));
        avionDao.persist(new Avion(2, kompanija, 200, "boing", "999"));
        avionDao.persist(new Avion(3, kompanija, 100, "boing", "474"));

        aerodromDao.persist(new Aerodrom(1, "Nikola Tesla", "BEG", "Beograd"));
        aerodromDao.persist(new Aerodrom(2, "Zanjice", "BEG", "Podgorica"));
        aerodromDao.persist(new Aerodrom(3, "Schiphol", "SCH", "Amsterdam"));

        // Let let1 = new Let(1, aerodrom, aerodrom3, avion2, new Date());
        // Let let2 = new Let(2, aerodrom2, aerodrom, avion, new Date());
        // Let let3 = new Let(3, aerodrom, aerodrom3, avion3, new Date());
        //
        // list.add(new Sediste(1, let1, null, false));
        // list.add(new Sediste(2, let2, null, false));
        // list.add(new Sediste(3, let3, null, false));

        korisnikDao.persist(new Korisnik(1, "Pera", "Peric", "a", "a"));
        korisnikDao.persist(new Korisnik(2, "Ana", "Anic", "b", "b"));
        korisnikDao.persist(new Korisnik(3, "Ceda", "Cedic", "c", "c"));

    }

    @Override
    protected AbstractDao<Sediste> getDao() {
        return sedisteDao;
    }

}
