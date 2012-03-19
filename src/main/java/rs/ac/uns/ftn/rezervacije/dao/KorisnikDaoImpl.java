package rs.ac.uns.ftn.rezervacije.dao;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import rs.ac.uns.ftn.rezervacije.model.Korisnik;

@Repository
class KorisnikDaoImpl extends BaseDao<Korisnik> implements KorisnikDao {

    public Korisnik findByIdUsernameAndEncodedPass(String username, String encodedPass) {
        try {
            return entityManager
                    .createQuery(
                            "SELECT o FROM " + persistentClass.getSimpleName() + " o WHERE o."
                                    + Korisnik.KORISNICKO_IME + " = ?1 AND o." + Korisnik.LOZINKA + " = ?2",
                            persistentClass).setParameter(1, username).setParameter(2, encodedPass).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

}
