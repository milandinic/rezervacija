package rs.ac.uns.ftn.rezervacije.stranice.kupac.pretraga;

import java.util.Iterator;
import java.util.List;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.spring.injection.annot.SpringBean;

import rs.ac.uns.ftn.rezervacije.RezervacijaSession;
import rs.ac.uns.ftn.rezervacije.model.Let;
import rs.ac.uns.ftn.rezervacije.service.DataProvider;
import rs.ac.uns.ftn.rezervacije.service.LetService;

public class LetRezultatiDataProvider extends DataProvider<Let> {

    private static final long serialVersionUID = 1L;

    @SpringBean
    private LetService letService;

    public LetRezultatiDataProvider() {
        super();
        Injector.get().inject(this);
    }

    public Iterator<Let> iterator(int first, int count) {
        List<Let> listOfLet = letService.pretragaLetova(RezervacijaSession.getSession().getPretraga());
        return listOfLet.iterator();
    }

    public int size() {
        return letService.countAll();
    }

}
