package rs.ac.uns.ftn.rezervacije.dao;

import java.util.List;

import rs.ac.uns.ftn.rezervacije.model.Let;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.home.Pretraga;

public interface LetDao extends AbstractDao<Let> {

    List<Let> findByPretraga(Pretraga pretraga, int first, int count);

    int countByPretragaLetova(Pretraga pretraga);

    List<Let> getAllByKompanija(int first, int count, Long kompanijaId);

    Long countAllByKompanija(Long kompanijaId);

}
