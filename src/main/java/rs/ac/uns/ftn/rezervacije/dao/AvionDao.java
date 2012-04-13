package rs.ac.uns.ftn.rezervacije.dao;

import java.util.List;

import rs.ac.uns.ftn.rezervacije.model.Avion;

public interface AvionDao extends AbstractDao<Avion> {

    List<Avion> getAllByCompany(int first, int count, Long kompanijaId);

    Long countAllByKompanija(Long kompanijaId);

}
