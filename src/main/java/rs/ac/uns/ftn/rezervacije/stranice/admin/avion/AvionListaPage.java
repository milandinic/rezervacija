package rs.ac.uns.ftn.rezervacije.stranice.admin.avion;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import rs.ac.uns.ftn.rezervacije.model.Avion;
import rs.ac.uns.ftn.rezervacije.stranice.admin.AbstractAdminPage;
import rs.ac.uns.ftn.rezervacije.stranice.common.SimpleGridCreator;

public class AvionListaPage extends AbstractAdminPage {

    private static final long serialVersionUID = -820528739421089772L;

    public AvionListaPage() {
        super();

        AvionDataProvider dataProvider = new AvionDataProvider();

        SimpleGridCreator<Avion> simpleGridCreator = new SimpleGridCreator<Avion>() {

            private static final long serialVersionUID = 6339218124885730536L;

            @Override
            public void hanldeRowClicked(AjaxRequestTarget target, IModel<Avion> rowModel) {
                Avion avion = rowModel.getObject();
                PageParameters parameters = new PageParameters();
                parameters.add(Avion.ID, avion.getId());
                setResponsePage(AvionPage.class, parameters);
            }
        };

        simpleGridCreator.addColumnItem("Proizvođač", Avion.PROIZVODJAC);
        simpleGridCreator.addColumnItem("Model", Avion.MODEL);
        simpleGridCreator.addColumnItem("Kapacitet", Avion.KAPACITET);

        add(simpleGridCreator.createGrid(dataProvider));

        add(new Link<Void>("add") {

            private static final long serialVersionUID = 4140532042907907057L;

            @Override
            public void onClick() {
                setResponsePage(AvionPage.class);
            }

        });
    }
}
