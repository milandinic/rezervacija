package rs.ac.uns.ftn.rezervacije.service;

import java.util.List;

import rs.ac.uns.ftn.rezervacije.model.Avion;

public interface AeroplaneService {

    List<Avion> getListOfAvion();

    int getListOfAvionSize();
}
