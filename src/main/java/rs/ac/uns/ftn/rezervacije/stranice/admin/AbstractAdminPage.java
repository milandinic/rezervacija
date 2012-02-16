package rs.ac.uns.ftn.rezervacije.stranice.admin;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import rs.ac.uns.ftn.rezervacije.stranice.AbstractRezervacijaPage;
import rs.ac.uns.ftn.rezervacije.stranice.admin.aerodrom.AerodromListaPage;
import rs.ac.uns.ftn.rezervacije.stranice.admin.avion.AvionListaPage;
import rs.ac.uns.ftn.rezervacije.stranice.admin.korisnik.KorisnikListaPage;

public abstract class AbstractAdminPage extends AbstractRezervacijaPage {

    private static final long serialVersionUID = 4332673505459326514L;

    public AbstractAdminPage() {
        super();
        WebMarkupContainer container = new WebMarkupContainer("menu");
        container.add(new BookmarkablePageLink<AvionListaPage>("avioni", AvionListaPage.class));
        container.add(new BookmarkablePageLink<AvionListaPage>("aerodromi", AerodromListaPage.class));
        container.add(new BookmarkablePageLink<AvionListaPage>("korisnici", KorisnikListaPage.class));
        add(container);
    }

}
