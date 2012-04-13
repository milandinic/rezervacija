package rs.ac.uns.ftn.rezervacije.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import rs.ac.uns.ftn.rezervacije.model.Avion;

@Repository
class AvionDaoImpl extends BaseDao<Avion> implements AvionDao {

    public List<Avion> getAllByCompany(int first, int count, Long kompanijaId) {
        return entityManager
                .createQuery("SELECT o FROM " + persistentClass.getSimpleName() + " o WHERE o.kompanija.id = ?1",
                        persistentClass).setParameter(1, kompanijaId).getResultList();
    }

    public Long countAllByKompanija(Long kompanijaId) {
        return entityManager
                .createQuery(
                        "SELECT count(o) FROM " + persistentClass.getSimpleName() + " o WHERE o.kompanija.id = ?1",
                        Long.class).setParameter(1, kompanijaId).getSingleResult();
    }

}
