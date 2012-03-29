package rs.ac.uns.ftn.rezervacije.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.rezervacije.model.AbstractPersistable;

public abstract class BaseDao<T extends AbstractPersistable> implements AbstractDao<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    protected final Class<T> persistentClass;

    /**
     * Constructor.
     */
    @SuppressWarnings("unchecked")
    protected BaseDao() {
        super();
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public List<T> findAll(int first, int count) {
        return entityManager.createQuery("SELECT o FROM " + persistentClass.getSimpleName() + " o", persistentClass)
                .setFirstResult(first).setMaxResults(count).getResultList();
    }

    public List<T> findAll() {
        return entityManager.createQuery("SELECT o FROM " + persistentClass.getSimpleName() + " o", persistentClass)
                .getResultList();
    }

    public Long countAll() {
        return entityManager.createQuery("SELECT count(o) FROM " + persistentClass.getSimpleName() + " o", Long.class)
                .getSingleResult();
    }

    @Transactional
    public void persist(T object) {
        System.out.println("BaseDao.persist()");
        this.entityManager.persist(object);
        this.entityManager.flush();
    }

    public T findById(Long id) {
        if (id == null) {
            return null;
        }
        return entityManager.find(persistentClass, id);
    }

    @Transactional
    public void remove(long id) {
        this.entityManager.remove(findById(id));
        flush();
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
        flush();
        return merged;
    }

}
