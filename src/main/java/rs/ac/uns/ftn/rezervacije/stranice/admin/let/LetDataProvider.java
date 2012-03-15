package rs.ac.uns.ftn.rezervacije.stranice.admin.let;

import java.util.Iterator;
import java.util.List;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.spring.injection.annot.SpringBean;

import rs.ac.uns.ftn.rezervacije.model.Let;
import rs.ac.uns.ftn.rezervacije.service.DataProvider;
import rs.ac.uns.ftn.rezervacije.service.LetService;

public class LetDataProvider extends DataProvider<Let> {

    private static final long serialVersionUID = 1L;

    @SpringBean
    private LetService letService;

    public LetDataProvider() {
        super();
        Injector.get().inject(this);
    }

    public Iterator<Let> iterator(int first, int count) {
        List<Let> listOfLet = letService.getAll();
        return listOfLet.iterator();
    }

    public int size() {
        return letService.countAll();
    }

}
