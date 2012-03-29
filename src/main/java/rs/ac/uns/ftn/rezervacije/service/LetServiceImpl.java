package rs.ac.uns.ftn.rezervacije.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.rezervacije.dao.AbstractDao;
import rs.ac.uns.ftn.rezervacije.dao.LetDao;
import rs.ac.uns.ftn.rezervacije.dao.SedisteDao;
import rs.ac.uns.ftn.rezervacije.model.Let;
import rs.ac.uns.ftn.rezervacije.model.Sediste;
import rs.ac.uns.ftn.rezervacije.model.TipSedista;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.home.Pretraga;

@Service
class LetServiceImpl extends ICRUDImpl<Let> implements LetService, Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private LetDao letDao;

    @Autowired
    private SedisteDao sedisteDao;

    @Override
    protected AbstractDao<Let> getDao() {
        return letDao;
    }

    @Override
    public void create(Let object) {

        super.create(object);

        int mestaEkonomska = object.getMestaEkonomska();
        for (int i = 0; i < mestaEkonomska; i++) {
            Sediste sediste = new Sediste();
            sediste.setLet(object);
            sediste.setTipSedista(TipSedista.EKONOMSKO);
            sediste.setCena(object.getCenaEkonomska());
            sedisteDao.persist(sediste);
        }

        int mestaPoslovna = object.getMestaPoslovna();
        for (int i = 0; i < mestaPoslovna; i++) {
            Sediste sediste = new Sediste();
            sediste.setLet(object);
            sediste.setTipSedista(TipSedista.POSLOVNO);
            sediste.setCena(object.getCenaPoslovna());
            sedisteDao.persist(sediste);
        }

    }

    public List<Let> pretragaLetova(Pretraga pretraga, int first, int count) {
        return letDao.findByPretraga(pretraga, first, count);
    }

    public int countByPretragaLetova(Pretraga pretraga) {
        return letDao.countByPretragaLetova(pretraga);
    }

}
