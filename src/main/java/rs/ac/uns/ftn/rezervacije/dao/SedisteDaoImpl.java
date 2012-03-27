package rs.ac.uns.ftn.rezervacije.dao;

import java.util.Collections;
import java.util.List;

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
        sb.append("AND s.placeno = 0 AND s.tipSedista = ?2 ");
        List<Sediste> result = entityManager.createQuery(sb.toString(), Sediste.class).setParameter(1, let.getId())
                .setParameter(2, tipSedista).setMaxResults(brojSedista.intValue()).getResultList();

        if (result.size() == brojSedista) {
            for (Sediste sediste : result) {
                sediste.setKorisnik(korisnik);
                sediste.setPlaceno(true);
                merge(sediste);
            }
            return result;
        } else {
            return Collections.EMPTY_LIST;
        }
    }

}
