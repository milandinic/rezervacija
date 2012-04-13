package rs.ac.uns.ftn.rezervacije.dao;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import rs.ac.uns.ftn.rezervacije.AbstractSpringTest;
import rs.ac.uns.ftn.rezervacije.model.Aerodrom;
import rs.ac.uns.ftn.rezervacije.model.Avion;
import rs.ac.uns.ftn.rezervacije.model.Kompanija;

public class AvionDaoTest extends AbstractSpringTest {

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
        avion.setKompanija(kompanija);
        avionDao.persist(avion);
        List<Avion> list = avionDao.getAllByCompany(0, 10, kompanija.getId());
        Assert.assertNotNull(list);
        Assert.assertFalse(list.isEmpty());
        Assert.assertEquals(1, list.size());

    }
}
