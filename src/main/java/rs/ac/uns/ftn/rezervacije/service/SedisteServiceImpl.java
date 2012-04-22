package rs.ac.uns.ftn.rezervacije.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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
import rs.ac.uns.ftn.rezervacije.model.Let;
import rs.ac.uns.ftn.rezervacije.model.Sediste;
import rs.ac.uns.ftn.rezervacije.model.TipKorisnika;
import rs.ac.uns.ftn.rezervacije.model.TipSedista;

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

    @Autowired
    private LetService letService;

    private static final Logger LOG = Logger.getLogger(SedisteServiceImpl.class);;

    public SedisteServiceImpl() {
        super();

    }

    @PostConstruct
    void demo() {

        Kompanija kompanija = new Kompanija();
        kompanija.setNaziv("Jat");

        kompanijaDao.persist(kompanija);

        Kompanija kompanija2 = new Kompanija();
        kompanija.setNaziv("Lufthans");

        kompanijaDao.persist(kompanija2);

        Avion avion = new Avion(1, kompanija, 2, "boing", "474");
        avionDao.persist(avion);
        Avion avion2 = new Avion(2, kompanija, 200, "boing", "999");
        avionDao.persist(avion2);
        Avion avion3 = new Avion(3, kompanija, 100, "boing", "474");
        avionDao.persist(avion3);

        Avion avion4 = new Avion(1, kompanija2, 100, "boing", "474");
        avionDao.persist(avion4);

        Aerodrom aerodrom1 = new Aerodrom(1, "Nikola Tesla", "BEG", "Beograd");
        aerodromDao.persist(aerodrom1);
        Aerodrom aerodrom2 = new Aerodrom(2, "Zanjice", "ZAN", "Podgorica");
        aerodromDao.persist(aerodrom2);
        Aerodrom aerodrom3 = new Aerodrom(3, "Schiphol", "SCH", "Amsterdam");
        aerodromDao.persist(aerodrom3);

        Let let4 = new Let(4, aerodrom1, aerodrom3, avion, "BS1");
        Let let1 = new Let(1, aerodrom1, aerodrom3, avion2, "BS2");
        Let let3 = new Let(3, aerodrom1, aerodrom3, avion3, "BS3");
        Let let2 = new Let(2, aerodrom2, aerodrom1, avion, "ZB");

        Let let5 = new Let(5, aerodrom2, aerodrom1, avion4, "ZBH");

        letService.create(let1);
        letService.create(let2);
        letService.create(let3);
        letService.create(let4);
        letService.create(let5);

        korisnikDao.persist(new Korisnik(1, "Pera", "Peric", "a", "a"));
        korisnikDao.persist(new Korisnik(2, "Ana", "Anic", "b", "b"));
        korisnikDao.persist(new Korisnik(3, "Ceda", "Cedic", "c", "c"));

        Korisnik admin = new Korisnik(4, "Admin", "amic", "ad", "ad", kompanija);
        admin.setTipKorisnika(TipKorisnika.ADMINISTRATOR);
        korisnikDao.persist(admin);

        Korisnik admin2 = new Korisnik(4, "Admin", "amic", "ad2", "ad2", kompanija2);
        admin2.setTipKorisnika(TipKorisnika.ADMINISTRATOR);
        korisnikDao.persist(admin2);

    }

    @Override
    protected AbstractDao<Sediste> getDao() {
        return sedisteDao;
    }

    public List<Sediste> rezervisiSediste(Let let, Korisnik korisnik, Long brojSedista, TipSedista tipSedista) {
        return sedisteDao.rezervisi(let, korisnik, brojSedista, tipSedista);
    }

    public List<Sediste> findByKorisnik(Korisnik korisnik, int first, int count) {
        return sedisteDao.findByKorisnik(korisnik, first, count);
    }

    public int countByKorisnik(Korisnik korisnik) {
        return sedisteDao.countByKorisnik(korisnik);
    }

    public int ponistiRezervacije(Korisnik korisnik) {
        return sedisteDao.ponistiRezervacije(korisnik);
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    public void ponistiIstekleRezervacije() {
        LOG.info("ponistiIstekleRezervacije");
        LOG.info("ponisteno rezervacija " + sedisteDao.ponistiIstekleRezervacije());
    }

    public boolean potvrdiRezervacije(Korisnik korisnik, List<Sediste> list) {
        Assert.notEmpty(list);
        int result = sedisteDao.potvrdiRezervacije(korisnik);
        if (result == list.size()) {
            return true;
        } else {
            for (Sediste sediste : list) {
                Sediste dbSediste = sedisteDao.findById(sediste.getId());
                dbSediste.setKorisnik(null);
                dbSediste.setProdato(false);
                dbSediste.setDatumRezervacije(null);
                sedisteDao.merge(dbSediste);
            }
            return false;
        }
    }
}
