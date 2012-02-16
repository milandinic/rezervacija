package rs.ac.uns.ftn.rezervacije.stranice.admin;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import rs.ac.uns.ftn.rezervacije.stranice.AbstractRezervacijaPage;
import rs.ac.uns.ftn.rezervacije.stranice.admin.avion.AvionListaPage;

public abstract class AbstractAdminPage extends AbstractRezervacijaPage {

    private static final long serialVersionUID = 4332673505459326514L;

    public AbstractAdminPage() {
        super();
        WebMarkupContainer container = new WebMarkupContainer("menu");
        container.add(new BookmarkablePageLink<AvionListaPage>("avioni", AvionListaPage.class));
        add(container);
    }

}
