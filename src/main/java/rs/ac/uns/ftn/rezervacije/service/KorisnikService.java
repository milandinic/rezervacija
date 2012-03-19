package rs.ac.uns.ftn.rezervacije.service;

import rs.ac.uns.ftn.rezervacije.model.Korisnik;

public interface KorisnikService extends ICRUD<Korisnik> {

    Korisnik authenticate(String username, String encodedPass);

}
