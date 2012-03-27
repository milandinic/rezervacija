package rs.ac.uns.ftn.rezervacije.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import rs.ac.uns.ftn.rezervacije.AbstractSpringTest;
import rs.ac.uns.ftn.rezervacije.model.Aerodrom;
import rs.ac.uns.ftn.rezervacije.model.Avion;
import rs.ac.uns.ftn.rezervacije.model.Kompanija;
import rs.ac.uns.ftn.rezervacije.model.Let;
import rs.ac.uns.ftn.rezervacije.service.LetService;

public class LetDaoTest extends AbstractSpringTest {

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

    @Test
    public void testInsertAndPretraga() {

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

    }
}
