package rs.ac.uns.ftn.rezervacije.service;

import java.util.List;

import rs.ac.uns.ftn.rezervacije.model.Korisnik;
import rs.ac.uns.ftn.rezervacije.model.Let;
import rs.ac.uns.ftn.rezervacije.model.Sediste;
import rs.ac.uns.ftn.rezervacije.model.TipSedista;

public interface SedisteService extends ICRUD<Sediste> {

    List<Sediste> rezervisiSediste(Let let, Korisnik korisnik, Long brojSedista, TipSedista tipSedista);

    List<Sediste> findByKorisnik(Korisnik korisnik, int first, int count);

    int countByKorisnik(Korisnik korisnik);

    int ponistiRezervacije(Korisnik korisnik);

    int ponistiRezervacije();

    boolean potvrdiRezervacije(Korisnik korisnik, List<Sediste> list);
}
