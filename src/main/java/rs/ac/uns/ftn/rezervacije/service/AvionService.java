package rs.ac.uns.ftn.rezervacije.service;

import java.util.List;

import rs.ac.uns.ftn.rezervacije.model.Avion;

public interface AvionService extends ICRUD<Avion> {

    List<Avion> getAllByCompany(int first, int count, Long kompanijaId);

    Long countAllByKompanija(Long kompanijaId);

}
