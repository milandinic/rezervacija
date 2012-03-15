package rs.ac.uns.ftn.rezervacije.stranice.admin.avion;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import rs.ac.uns.ftn.rezervacije.model.Avion;
import rs.ac.uns.ftn.rezervacije.stranice.admin.AbstractAdminPage;

import com.inmethod.grid.DataProviderAdapter;
import com.inmethod.grid.IGridColumn;
import com.inmethod.grid.column.PropertyColumn;
import com.inmethod.grid.datagrid.DataGrid;
import com.inmethod.grid.datagrid.DefaultDataGrid;

public class AvionListaPage extends AbstractAdminPage {

    private static final long serialVersionUID = -820528739421089772L;

    public AvionListaPage() {
        super();

        AvionDataProvider dataProvider = new AvionDataProvider();

        List<IGridColumn> cols = (List) Arrays.asList(new PropertyColumn(new Model("Proizvođač"), Avion.PROIZVODJAC),
                new PropertyColumn(new Model("Model"), Avion.MODEL), new PropertyColumn(new Model("Kapacitet"),
                        Avion.KAPACITET));

        DataGrid grid = new DefaultDataGrid("grid", new DataProviderAdapter<Avion>(dataProvider), cols) {

            private static final long serialVersionUID = -2388101643712962470L;

            @Override
            protected void onRowClicked(AjaxRequestTarget target, IModel rowModel) {
                super.onRowClicked(target, rowModel);
                Avion avion = (Avion) rowModel.getObject();
                PageParameters parameters = new PageParameters();
                parameters.add(Avion.ID, avion.getId());
                setResponsePage(AvionPage.class, parameters);
            }
        };
        add(grid);

        add(new Link<Void>("add") {

            private static final long serialVersionUID = 4140532042907907057L;

            @Override
            public void onClick() {
                setResponsePage(AvionPage.class);
            }

        });
    }
}
