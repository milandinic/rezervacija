package rs.ac.uns.ftn.rezervacije.service;

import java.util.List;

import rs.ac.uns.ftn.rezervacije.dao.AbstractDao;
import rs.ac.uns.ftn.rezervacije.model.AbstractPersistable;

abstract class ICRUDImpl<T extends AbstractPersistable> implements ICRUD<T> {

    protected abstract AbstractDao<T> getDao();

    public void update(T object) {
        getDao().merge(object);
    }

    public void create(T object) {
        getDao().persist(object);
    }

    public void deleteById(long id) {
        getDao().remove(id);
    }

    public T getById(long id) {
        return getDao().findById(id);
    }

    public List<T> getAll(int first, int count) {
        return getDao().findAll(first, count);
    }

    public List<T> getAll() {
        return getDao().findAll();
    }

    public int countAll() {
        return getDao().countAll().intValue();
    }

}
