package rs.ac.uns.ftn.rezervacije.dao;

import java.util.List;

import rs.ac.uns.ftn.rezervacije.model.AbstractPersistable;

public interface AbstractDao<T extends AbstractPersistable> {

    List<T> findAll();

    Integer countAll();

    T merge(T object);

    void flush();

    void clear();

    T findById(Long id);

    void persist(T object);

}
