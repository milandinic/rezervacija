package rs.ac.uns.ftn.rezervacije.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.rezervacije.model.AbstractPersistable;

abstract class BaseDao<T extends AbstractPersistable> implements AbstractDao<T> {

    @PersistenceContext
    private EntityManager entityManager;

    private final Class<T> persistentClass;

    /**
     * Constructor.
     */
    @SuppressWarnings("unchecked")
    protected BaseDao() {
        super();
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public List<T> findAll() {
        return entityManager.createQuery("SELECT o FROM " + getClass().getSimpleName() + " o", persistentClass)
                .getResultList();
    }

    public Integer countAll() {
        return entityManager.createQuery("SELECT count(o) FROM " + getClass().getSimpleName() + " o", Integer.class)
                .getSingleResult();
    }

    @Transactional
    public void persist(T object) {
        this.entityManager.persist(object);
    }

    public T findById(Long id) {
        if (id == null) {
            return null;
        }
        return entityManager.find(persistentClass, id);
    }

    @Transactional
    public void remove(T object) {
        if (this.entityManager.contains(object)) {
            this.entityManager.remove(object);
        } else {
            T attached = findById(object.getId());
            this.entityManager.remove(attached);
        }
    }

    @Transactional
    public void flush() {
        this.entityManager.flush();
    }

    @Transactional
    public void clear() {
        this.entityManager.clear();
    }

    @Transactional
    public T merge(T object) {
        T merged = this.entityManager.merge(object);
        this.entityManager.flush();
        return merged;
    }

}
