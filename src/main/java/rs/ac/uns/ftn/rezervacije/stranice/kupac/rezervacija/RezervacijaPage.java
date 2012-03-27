package rs.ac.uns.ftn.rezervacije.stranice.kupac.rezervacija;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;

import rs.ac.uns.ftn.rezervacije.RezervacijaSession;
import rs.ac.uns.ftn.rezervacije.model.Let;
import rs.ac.uns.ftn.rezervacije.model.Sediste;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.AbstractKupacPage;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.Korak;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.home.HomePage;

import com.inmethod.grid.DataProviderAdapter;
import com.inmethod.grid.IGridColumn;
import com.inmethod.grid.column.PropertyColumn;
import com.inmethod.grid.datagrid.DataGrid;
import com.inmethod.grid.datagrid.DefaultDataGrid;

public class RezervacijaPage extends AbstractKupacPage {

    private static final long serialVersionUID = -1550978776316588651L;

    public RezervacijaPage() {
        super();

        if (!RezervacijaSession.getSession().getKorak().equals(Korak.LISTA_LETOVA)) {
            throw new RestartResponseAtInterceptPageException(HomePage.class);
        }
        RezervacijaSession.getSession().setKorak(Korak.NONE);

        WebMarkupContainer container = new WebMarkupContainer("let");
        container.setDefaultModel(new CompoundPropertyModel<Let>(RezervacijaSession.getSession().getLet()));
        add(container);
        container.add(new Label(Let.SIFRA));
        container.add(new Label(Let.AVION));
        container.add(new Label(Let.AERODROM_DOLASKA + ".naziv"));
        container.add(new Label(Let.AERODROM_POLASKA + ".naziv"));

        SedistaDataProvider dataProvider = new SedistaDataProvider();

        List<IGridColumn> cols = (List) Arrays.asList(new PropertyColumn(new Model("ID"), Sediste.ID),
                new PropertyColumn(new Model("Klasa"), Sediste.TIP_SEDISTA));

        DataGrid grid = new DefaultDataGrid("grid", new DataProviderAdapter<Sediste>(dataProvider), cols);
        add(grid);
    }

}
