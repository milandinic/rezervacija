package rs.ac.uns.ftn.rezervacije.dao;

import java.util.List;

import rs.ac.uns.ftn.rezervacije.model.AbstractPersistable;

public interface AbstractDao<T extends AbstractPersistable> {

    List<T> findAll();

    List<T> findAll(int first, int count);

    Long countAll();

    T merge(T object);

    void flush();

    void remove(long id);

    void clear();

    T findById(Long id);

    void persist(T object);

}
