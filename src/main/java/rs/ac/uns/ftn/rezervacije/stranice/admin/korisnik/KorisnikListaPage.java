package rs.ac.uns.ftn.rezervacije.stranice.admin.korisnik;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import rs.ac.uns.ftn.rezervacije.model.Korisnik;
import rs.ac.uns.ftn.rezervacije.stranice.admin.AbstractAdminPage;
import rs.ac.uns.ftn.rezervacije.stranice.common.SimpleGridCreator;

public class KorisnikListaPage extends AbstractAdminPage {

    private static final long serialVersionUID = -820528739421089772L;

    public KorisnikListaPage() {
        super();

        KorisnikDataProvider dataProvider = new KorisnikDataProvider();

        SimpleGridCreator<Korisnik> simpleGridCreator = new SimpleGridCreator<Korisnik>() {

            @Override
            public void hanldeRowClicked(AjaxRequestTarget target, IModel<Korisnik> rowModel) {
                Korisnik avion = rowModel.getObject();
                PageParameters parameters = new PageParameters();
                parameters.add(Korisnik.ID, avion.getId());
                setResponsePage(KorisnikPage.class, parameters);
            }
        };

        simpleGridCreator.addColumnItem("Ime", Korisnik.IME);
        simpleGridCreator.addColumnItem("Prezime", Korisnik.PREZIME);
        simpleGridCreator.addColumnItem("Korisnicko ime", Korisnik.KORISNICKO_IME);

        add(simpleGridCreator.createGrid(dataProvider));

        add(new Link<Void>("add") {

            private static final long serialVersionUID = 4140532042907907057L;

            @Override
            public void onClick() {
                setResponsePage(KorisnikPage.class);
            }

        });
    }
}
