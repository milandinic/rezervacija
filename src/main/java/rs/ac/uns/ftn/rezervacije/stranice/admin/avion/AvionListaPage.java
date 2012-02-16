package rs.ac.uns.ftn.rezervacije.stranice.admin.avion;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.model.Model;

import rs.ac.uns.ftn.rezervacije.model.Avion;
import rs.ac.uns.ftn.rezervacije.stranice.AbstractRezervacijaPage;

import com.inmethod.grid.DataProviderAdapter;
import com.inmethod.grid.IGridColumn;
import com.inmethod.grid.column.PropertyColumn;
import com.inmethod.grid.datagrid.DataGrid;
import com.inmethod.grid.datagrid.DefaultDataGrid;

public class AvionListaPage extends AbstractRezervacijaPage {

    private static final long serialVersionUID = -820528739421089772L;

    public AvionListaPage() {
        super();

        AvionDataProvider dataProvider = new AvionDataProvider();

        List<IGridColumn> cols = (List) Arrays.asList(new PropertyColumn(new Model("Naziv"), Avion.NAZIV),
                new PropertyColumn(new Model("Kapacitet"), Avion.KAPACITET));

        DataGrid grid = new DefaultDataGrid("grid", new DataProviderAdapter<Avion>(dataProvider), cols);
        add(grid);
    }
}
