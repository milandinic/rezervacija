package rs.ac.uns.ftn.rezervacije.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import rs.ac.uns.ftn.rezervacije.model.Let;
import rs.ac.uns.ftn.rezervacije.model.TipSedista;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.home.Pretraga;

@Repository
class LetDaoImpl extends BaseDao<Let> implements LetDao {

    public List<Let> findByPretraga(Pretraga pretraga) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT distinct o FROM Let o, Sediste s WHERE o.id = s.let.id ");
        sb.append("AND o.aerodromPolaska.id = ?1 AND o.aerodromDolaska.id = ?2 ");
        sb.append("AND s.korisnik.id is NULL AND s.tipSedista = ?3 group by o.id having count(s.id)> ?4");
        return entityManager.createQuery(sb.toString(), Let.class)
                .setParameter(1, pretraga.getAerodromPolaska().getId())
                .setParameter(2, pretraga.getAerodromDolaska().getId())
                .setParameter(3, pretraga.getPoslovnaKlasa() ? TipSedista.POSLOVNO : TipSedista.EKONOMSKO)
                .setParameter(4, pretraga.getBrojPutnika()).getResultList();
    }
}
