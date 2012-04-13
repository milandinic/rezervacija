package rs.ac.uns.ftn.rezervacije.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import rs.ac.uns.ftn.rezervacije.AbstractSpringTest;
import rs.ac.uns.ftn.rezervacije.model.Korisnik;

public class KorisnikDaoTest extends AbstractSpringTest {

    @Autowired
    private KorisnikDao korisnikDao;

    @Test
    public void testInsertAndPretraga() {

        korisnikDao.persist(new Korisnik(1, "Pera", "Peric", "z", "a"));
        korisnikDao.persist(new Korisnik(2, "Ana", "Anic", "x", "b"));
        korisnikDao.persist(new Korisnik(3, "Ceda", "Cedic", "f", "c"));

        Assert.assertNotNull(korisnikDao.findByKorisnickoIme("f"));
        Assert.assertNull(korisnikDao.findByKorisnickoIme("d"));
    }
}
