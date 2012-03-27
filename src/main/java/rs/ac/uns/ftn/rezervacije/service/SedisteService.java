package rs.ac.uns.ftn.rezervacije.service;

import java.util.List;

import rs.ac.uns.ftn.rezervacije.model.Korisnik;
import rs.ac.uns.ftn.rezervacije.model.Let;
import rs.ac.uns.ftn.rezervacije.model.Sediste;
import rs.ac.uns.ftn.rezervacije.model.TipSedista;

public interface SedisteService extends ICRUD<Sediste> {

    List<Sediste> pretragaSediste(Let let, Korisnik korisnik, int brojSedista, TipSedista tipSedista);

    List<Sediste> rezervisiSediste(Let let, Korisnik korisnik, int brojSedista, TipSedista tipSedista,
            List<Sediste> sedista);
}
