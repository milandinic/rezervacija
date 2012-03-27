package rs.ac.uns.ftn.rezervacije.service;

import java.io.Serializable;

import org.h2.security.SHA256;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.rezervacije.dao.AbstractDao;
import rs.ac.uns.ftn.rezervacije.dao.KorisnikDao;
import rs.ac.uns.ftn.rezervacije.model.Korisnik;

@Service
class KorisnikServiceImpl extends ICRUDImpl<Korisnik> implements KorisnikService, Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private KorisnikDao korisnikDao;

    @Override
    protected AbstractDao<Korisnik> getDao() {
        return korisnikDao;
    }

    public Korisnik authenticate(String username, String encodedPass) {
        return korisnikDao.findByIdUsernameAndEncodedPass(username, encodedPass);
    }

    public void updatePassword(Korisnik korisnik) {
        korisnik.setLozinka(new String(SHA256.getKeyPasswordHash(korisnik.getKorisnickoIme(), korisnik.getLozinka()
                .toCharArray())));
        korisnikDao.merge(korisnik);

    }

}
