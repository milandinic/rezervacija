package rs.ac.uns.ftn.rezervacije.dao;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import rs.ac.uns.ftn.rezervacije.AbstractSpringTest;
import rs.ac.uns.ftn.rezervacije.model.Aerodrom;
import rs.ac.uns.ftn.rezervacije.model.Avion;
import rs.ac.uns.ftn.rezervacije.model.Kompanija;
import rs.ac.uns.ftn.rezervacije.model.Korisnik;
import rs.ac.uns.ftn.rezervacije.model.Let;
import rs.ac.uns.ftn.rezervacije.model.Sediste;
import rs.ac.uns.ftn.rezervacije.model.TipSedista;
import rs.ac.uns.ftn.rezervacije.service.LetService;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.home.Pretraga;

public class SedisteDaoTest extends AbstractSpringTest {

    @Autowired
    private LetDao letDao;

    @Autowired
    private LetService letService;

    @Autowired
    private AvionDao avionDao;

    @Autowired
    private KompanijaDao kompanijaDao;

    @Autowired
    private AerodromDao aerodromDao;

    @Autowired
    private SedisteDao sedisteDao;

    @Autowired
    private KorisnikDao korisnikDao;

    @Test
    public void testInsertAndPretraga() {

        Korisnik korisnik = new Korisnik(1, "Pera", "Peric", "a", "a");
        korisnikDao.persist(korisnik);
        korisnikDao.persist(new Korisnik(2, "Ana", "Anic", "b", "b"));
        korisnikDao.persist(new Korisnik(3, "Ceda", "Cedic", "c", "c"));

        Kompanija kompanija = new Kompanija();
        kompanija.setNaziv("jat");
        kompanijaDao.persist(kompanija);

        Aerodrom aerodrom1 = new Aerodrom(1, "Nikola Tesla", "BEG", "Beograd");
        aerodromDao.persist(aerodrom1);
        Aerodrom aerodrom2 = new Aerodrom(2, "Zanjice", "BEG", "Podgorica");
        aerodromDao.persist(aerodrom2);
        Aerodrom aerodrom3 = new Aerodrom(3, "Schiphol", "SCH", "Amsterdam");
        aerodromDao.persist(aerodrom3);

        Avion avion = new Avion();
        avion.setKapacitet(100);
        avion.setModel("747");
        avion.setKompanija(kompanija);
        avion.setProizvodjac("boing");
        avionDao.persist(avion);

        Let let = new Let();
        let.setMestaEkonomska(10);
        let.setMestaPoslovna(5);
        let.setCenaEkonomska(100);
        let.setCenaPoslovna(200);
        let.setAvion(avion);
        let.setAerodromDolaska(aerodrom1);
        let.setAerodromPolaska(aerodrom2);
        let.setSifra("Sa1");
        let.setAvion(avion);

        letService.create(let);

        Pretraga pretraga = new Pretraga();
        pretraga.setAerodromDolaska(aerodrom1);
        pretraga.setAerodromPolaska(aerodrom2);
        pretraga.setBrojPutnika(2L);
        pretraga.setPoslovnaKlasa(true);

        List<Let> list = letDao.findByPretraga(pretraga, 0, 10);
        Assert.assertNotNull(list);
        Assert.assertFalse(list.isEmpty());

        List<Sediste> result = sedisteDao.rezervisi(let, korisnik, 2L, TipSedista.POSLOVNO);
        Assert.assertNotNull(result);
        Assert.assertFalse(result.isEmpty());
        Assert.assertEquals(2, result.size());

        result = sedisteDao.rezervisi(let, korisnik, 4L, TipSedista.POSLOVNO);
        Assert.assertNotNull(result);
        Assert.assertTrue(result.isEmpty());

        result = sedisteDao.rezervisi(let, korisnik, 3L, TipSedista.POSLOVNO);
        Assert.assertNotNull(result);
        Assert.assertFalse(result.isEmpty());
        Assert.assertEquals(3, result.size());
    }
}
