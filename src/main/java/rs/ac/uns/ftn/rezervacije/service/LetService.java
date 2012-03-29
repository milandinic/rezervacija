package rs.ac.uns.ftn.rezervacije.service;

import java.util.List;

import rs.ac.uns.ftn.rezervacije.model.Let;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.home.Pretraga;

public interface LetService extends ICRUD<Let> {

    List<Let> pretragaLetova(Pretraga pretraga, int first, int count);

    int countByPretragaLetova(Pretraga pretraga);

}
