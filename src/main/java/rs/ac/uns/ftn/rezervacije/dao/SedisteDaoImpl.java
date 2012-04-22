package rs.ac.uns.ftn.rezervacije.dao;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.rezervacije.model.Korisnik;
import rs.ac.uns.ftn.rezervacije.model.Let;
import rs.ac.uns.ftn.rezervacije.model.Sediste;
import rs.ac.uns.ftn.rezervacije.model.TipSedista;

@Repository
class SedisteDaoImpl extends BaseDao<Sediste> implements SedisteDao {

    @SuppressWarnings("unchecked")
    @Transactional
    public List<Sediste> rezervisi(Let let, Korisnik korisnik, Long brojSedista, TipSedista tipSedista) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT s FROM Sediste s WHERE s.let.id = ?1 ");
        sb.append("AND s.korisnik.id is NULL AND s.tipSedista = ?2 ");
        List<Sediste> result = entityManager.createQuery(sb.toString(), Sediste.class).setParameter(1, let.getId())
                .setParameter(2, tipSedista).setMaxResults(brojSedista.intValue()).getResultList();

        if (result.size() == brojSedista) {
            Date date = new Date();
            for (Sediste sediste : result) {
                sediste.setDatumRezervacije(date);
                sediste.setKorisnik(korisnik);
                sediste.setProdato(false);
                merge(sediste);
            }
            return result;
        } else {
            return Collections.EMPTY_LIST;
        }
    }

    public List<Sediste> findByKorisnik(Korisnik korisnik, int first, int count) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT s FROM Sediste s WHERE s.korisnik.id = ?1 ");
        return entityManager.createQuery(sb.toString(), Sediste.class).setParameter(1, korisnik.getId())
                .setFirstResult(first).setMaxResults(count).getResultList();

    }

    public int countByKorisnik(Korisnik korisnik) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT count(s) FROM Sediste s WHERE s.korisnik.id = ?1 ");
        return entityManager.createQuery(sb.toString(), Long.class).setParameter(1, korisnik.getId()).getSingleResult()
                .intValue();
    }

    @Transactional
    public int ponistiRezervacije(Korisnik korisnik) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE sediste s SET s.korisnik = NULL, s.datum_rezervacije = NULL ");
        sb.append("WHERE s.korisnik = ?1 AND s.prodato = 0");
        return entityManager.createNativeQuery(sb.toString()).setParameter(1, korisnik.getId()).executeUpdate();
    }

    @Transactional
    public int ponistiIstekleRezervacije() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE sediste s SET s.korisnik = NULL, s.datum_rezervacije = NULL ");
        sb.append("WHERE s.prodato = 0 AND s.datum_rezervacije < ?1");
        return entityManager.createNativeQuery(sb.toString()).setParameter(1, DateUtils.addMinutes(new Date(), -2))
                .executeUpdate();
    }

    @Transactional
    public int potvrdiRezervacije(Korisnik korisnik) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE sediste s SET s.prodato = 1 ");
        sb.append("WHERE s.korisnik = ?1 AND s.prodato = 0");
        return entityManager.createNativeQuery(sb.toString()).setParameter(1, korisnik.getId()).executeUpdate();
    }
}
