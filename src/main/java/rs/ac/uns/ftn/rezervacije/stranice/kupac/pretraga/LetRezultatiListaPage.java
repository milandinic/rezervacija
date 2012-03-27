package rs.ac.uns.ftn.rezervacije.stranice.kupac.pretraga;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import rs.ac.uns.ftn.rezervacije.RezervacijaSession;
import rs.ac.uns.ftn.rezervacije.model.Let;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.AbstractKupacPage;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.home.HomePage;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.home.Pretraga;

import com.inmethod.grid.DataProviderAdapter;
import com.inmethod.grid.IGridColumn;
import com.inmethod.grid.column.PropertyColumn;
import com.inmethod.grid.datagrid.DataGrid;
import com.inmethod.grid.datagrid.DefaultDataGrid;

public class LetRezultatiListaPage extends AbstractKupacPage {

    private static final long serialVersionUID = -820528739421089772L;

    public LetRezultatiListaPage() {
        super();

        Pretraga pretraga = RezervacijaSession.getSession().getPretraga();
        if (pretraga.isIzvrsena()) {
            throw new RestartResponseAtInterceptPageException(HomePage.class);
        }

        LetRezultatiDataProvider dataProvider = new LetRezultatiDataProvider();

        List<IGridColumn> cols = (List) Arrays.asList(new PropertyColumn(new Model("Aerodrom polaska"),
                Let.AERODROM_POLASKA_NAZIV), new PropertyColumn(new Model("Aerodrom dolaska"),
                Let.AERODROM_DOLASKA_NAZIV), new PropertyColumn(new Model("Sifra"), Let.SIFRA), new PropertyColumn(
                new Model("Mesta ekonomska"), Let.MESTA_EKONOMSKA), new PropertyColumn(new Model("Mesta poslovna"),
                Let.MESTA_POSLOVNA), new PropertyColumn(new Model("Cena poslovna"), Let.CENA_POSLOVNA),
                new PropertyColumn(new Model("Cena ekonomska"), Let.CENA_EKONOMSKA));

        // List<IGridColumn> cols = (List) Arrays.asList(new PropertyColumn(new
        // Model("Aerodrom polaska"),
        // Let.AERODROM_POLASKA_NAZIV), new PropertyColumn(new
        // Model("Aerodrom dolaska"),
        // Let.AERODROM_DOLASKA_NAZIV), new PropertyColumn(new Model("Sifra"),
        // Let.SIFRA), new PropertyColumn(
        // new Model("Polazak"), Let.VREME_POLASKA));
        //
        // // if
        // (RezervacijaSession.getSession().getPretraga().getPoslovnaKlasa())
        // // {
        // cols.add(new PropertyColumn(new Model("Mesta poslovna"),
        // Let.MESTA_POSLOVNA));
        // cols.add(new PropertyColumn(new Model("Cena poslovna"),
        // Let.CENA_POSLOVNA));
        // // } else {
        // cols.add(new PropertyColumn(new Model("Mesta ekonomska"),
        // Let.MESTA_EKONOMSKA));
        // cols.add(new PropertyColumn(new Model("Cena ekonomska"),
        // Let.CENA_EKONOMSKA));
        // // }

        DataGrid grid = new DefaultDataGrid("grid", new DataProviderAdapter<Let>(dataProvider), cols) {

            private static final long serialVersionUID = -2388101643712962470L;

            @Override
            protected void onRowClicked(AjaxRequestTarget target, IModel rowModel) {
                super.onRowClicked(target, rowModel);
                Let Let = (Let) rowModel.getObject();
                PageParameters parameters = new PageParameters();
                parameters.add(Let.ID, Let.getId());
                // setResponsePage(LetPage.class, parameters);
            }
        };
        add(grid);

        add(new Link<Void>("add") {

            private static final long serialVersionUID = 4140532042907907057L;

            @Override
            public void onClick() {
                // setResponsePage(LetPage.class);
            }

        });
    }
}
