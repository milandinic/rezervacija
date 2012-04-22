package rs.ac.uns.ftn.rezervacije.dao;

import java.util.List;

import rs.ac.uns.ftn.rezervacije.model.Korisnik;
import rs.ac.uns.ftn.rezervacije.model.Let;
import rs.ac.uns.ftn.rezervacije.model.Sediste;
import rs.ac.uns.ftn.rezervacije.model.TipSedista;

public interface SedisteDao extends AbstractDao<Sediste> {

    List<Sediste> rezervisi(Let let, Korisnik korisnik, Long brojSedista, TipSedista tipSedista);

    List<Sediste> findByKorisnik(Korisnik korisnik, int first, int count);

    int countByKorisnik(Korisnik korisnik);

    int ponistiRezervacije(Korisnik korisnik);

    int ponistiIstekleRezervacije();

    int potvrdiRezervacije(Korisnik korisnik);
}
