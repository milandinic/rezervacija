package rs.ac.uns.ftn.rezervacije.service;

import java.util.List;

import rs.ac.uns.ftn.rezervacije.model.AbstractPersistable;

public interface ICRUD<T extends AbstractPersistable> {

    void update(T object);

    void create(T object);

    void deleteById(long id);

    T getById(long id);

    List<T> getAll();

    int countAll();

}
