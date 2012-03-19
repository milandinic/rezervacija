package rs.ac.uns.ftn.rezervacije.dao;

import rs.ac.uns.ftn.rezervacije.model.Korisnik;

public interface KorisnikDao extends AbstractDao<Korisnik> {

    Korisnik findByIdUsernameAndEncodedPass(String username, String encodedPass);

}
