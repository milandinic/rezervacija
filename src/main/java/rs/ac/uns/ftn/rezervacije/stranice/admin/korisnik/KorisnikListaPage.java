package rs.ac.uns.ftn.rezervacije.stranice.admin.korisnik;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import rs.ac.uns.ftn.rezervacije.model.Korisnik;
import rs.ac.uns.ftn.rezervacije.stranice.admin.AbstractAdminPage;

import com.inmethod.grid.DataProviderAdapter;
import com.inmethod.grid.IGridColumn;
import com.inmethod.grid.column.PropertyColumn;
import com.inmethod.grid.datagrid.DataGrid;
import com.inmethod.grid.datagrid.DefaultDataGrid;

public class KorisnikListaPage extends AbstractAdminPage {

    private static final long serialVersionUID = -820528739421089772L;

    public KorisnikListaPage() {
        super();

        KorisnikDataProvider dataProvider = new KorisnikDataProvider();

        List<IGridColumn> cols = (List) Arrays.asList(new PropertyColumn(new Model("Ime"), Korisnik.IME),
                new PropertyColumn(new Model("Korisnicko ime"), Korisnik.KORISNICKO_IME));

        DataGrid grid = new DefaultDataGrid("grid", new DataProviderAdapter<Korisnik>(dataProvider), cols) {

            private static final long serialVersionUID = -2388101643712962470L;

            @Override
            protected void onRowClicked(AjaxRequestTarget target, IModel rowModel) {
                super.onRowClicked(target, rowModel);
                Korisnik avion = (Korisnik) rowModel.getObject();
                PageParameters parameters = new PageParameters();
                parameters.add(Korisnik.ID, avion.getId());
                setResponsePage(KorisnikPage.class, parameters);
            }
        };
        add(grid);

        add(new Link<Void>("add") {

            private static final long serialVersionUID = 4140532042907907057L;

            @Override
            public void onClick() {
                setResponsePage(KorisnikPage.class);
            }

        });
    }
}
