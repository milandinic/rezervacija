package rs.ac.uns.ftn.rezervacije.stranice.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import com.inmethod.grid.DataProviderAdapter;
import com.inmethod.grid.IGridColumn;
import com.inmethod.grid.column.PropertyColumn;
import com.inmethod.grid.datagrid.DefaultDataGrid;

public class SimpleGridCreator<M> {

    private final List<IGridColumn<DataProviderAdapter<M>, M>> cols = new ArrayList<IGridColumn<DataProviderAdapter<M>, M>>();

    public DefaultDataGrid<DataProviderAdapter<M>, M> createGrid(IDataProvider<M> dataProvider) {
        return new DefaultDataGrid<DataProviderAdapter<M>, M>("grid", new DataProviderAdapter<M>(dataProvider), cols) {

            private static final long serialVersionUID = -6262914251527505026L;

            @Override
            protected void onRowClicked(AjaxRequestTarget target, IModel<M> rowModel) {
                hanldeRowClicked(target, rowModel);
            };
        };
    }

    /**
     * over ride if needed
     * 
     * @param target
     * @param rowModel
     */
    public void hanldeRowClicked(AjaxRequestTarget target, IModel<M> rowModel) {

    }

    public void addColumnItem(String label, String columnName) {
        cols.add(new PropertyColumn<DataProviderAdapter<M>, M, String>(new Model<String>(label), columnName));
    }
}
