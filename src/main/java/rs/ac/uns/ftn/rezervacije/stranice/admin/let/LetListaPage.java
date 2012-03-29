package rs.ac.uns.ftn.rezervacije.stranice.admin.let;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import rs.ac.uns.ftn.rezervacije.model.Let;
import rs.ac.uns.ftn.rezervacije.stranice.admin.AbstractAdminPage;
import rs.ac.uns.ftn.rezervacije.stranice.common.SimpleGridCreator;

public class LetListaPage extends AbstractAdminPage {

    private static final long serialVersionUID = -820528739421089772L;

    public LetListaPage() {
        super();

        LetDataProvider dataProvider = new LetDataProvider();
        SimpleGridCreator<Let> simpleGridCreator = new SimpleGridCreator<Let>() {

            private static final long serialVersionUID = 7490279855734481742L;

            @Override
            public void hanldeRowClicked(AjaxRequestTarget target, IModel<Let> rowModel) {
                Let let = rowModel.getObject();
                PageParameters parameters = new PageParameters();
                parameters.add(Let.ID, let.getId());
                setResponsePage(LetPage.class, parameters);
            }
        };

        simpleGridCreator.addColumnItem("Aerodrom polaska", Let.AERODROM_POLASKA_NAZIV);
        simpleGridCreator.addColumnItem("Aerodrom dolaska", Let.AERODROM_DOLASKA_NAZIV);
        simpleGridCreator.addColumnItem("Sifra", Let.SIFRA);
        simpleGridCreator.addColumnItem("Mesta ekonomska", Let.MESTA_EKONOMSKA);
        simpleGridCreator.addColumnItem("Mesta poslovna", Let.MESTA_POSLOVNA);
        simpleGridCreator.addColumnItem("Cena ekonomska", Let.CENA_EKONOMSKA);
        simpleGridCreator.addColumnItem("Cena poslovna", Let.CENA_POSLOVNA);

        add(simpleGridCreator.createGrid(dataProvider));

        add(new Link<Void>("add") {

            private static final long serialVersionUID = 4140532042907907057L;

            @Override
            public void onClick() {
                setResponsePage(LetPage.class);
            }

        });
    }
}
