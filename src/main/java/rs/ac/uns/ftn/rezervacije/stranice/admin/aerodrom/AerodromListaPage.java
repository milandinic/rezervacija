package rs.ac.uns.ftn.rezervacije.stranice.admin.aerodrom;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import rs.ac.uns.ftn.rezervacije.model.Aerodrom;
import rs.ac.uns.ftn.rezervacije.stranice.admin.AbstractAdminPage;
import rs.ac.uns.ftn.rezervacije.stranice.common.SimpleGridCreator;

public class AerodromListaPage extends AbstractAdminPage {

    private static final long serialVersionUID = -820528739421089772L;

    public AerodromListaPage() {
        super();

        AerodromDataProvider dataProvider = new AerodromDataProvider();

        SimpleGridCreator<Aerodrom> simpleGridCreator = new SimpleGridCreator<Aerodrom>() {

            @Override
            public void hanldeRowClicked(AjaxRequestTarget target, IModel<Aerodrom> rowModel) {
                Aerodrom avion = rowModel.getObject();
                PageParameters parameters = new PageParameters();
                parameters.add(Aerodrom.ID, avion.getId());
                setResponsePage(AerodromPage.class, parameters);
            }
        };

        simpleGridCreator.addColumnItem("Naziv", Aerodrom.NAZIV);
        simpleGridCreator.addColumnItem("Šifra", Aerodrom.SIFRA);
        simpleGridCreator.addColumnItem("Mesto", Aerodrom.MESTO);

        add(simpleGridCreator.createGrid(dataProvider));

        add(new Link<Void>("add") {

            private static final long serialVersionUID = 4140532042907907057L;

            @Override
            public void onClick() {
                setResponsePage(AerodromPage.class);
            }

        });
    }
}
