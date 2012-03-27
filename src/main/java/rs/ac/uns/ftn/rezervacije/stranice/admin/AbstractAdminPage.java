package rs.ac.uns.ftn.rezervacije.stranice.admin;

import org.apache.wicket.RestartResponseException;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import rs.ac.uns.ftn.rezervacije.RezervacijaSession;
import rs.ac.uns.ftn.rezervacije.model.Korisnik;
import rs.ac.uns.ftn.rezervacije.model.TipKorisnika;
import rs.ac.uns.ftn.rezervacije.stranice.AbstractRezervacijaPage;
import rs.ac.uns.ftn.rezervacije.stranice.admin.aerodrom.AerodromListaPage;
import rs.ac.uns.ftn.rezervacije.stranice.admin.avion.AvionListaPage;
import rs.ac.uns.ftn.rezervacije.stranice.admin.korisnik.KorisnikListaPage;
import rs.ac.uns.ftn.rezervacije.stranice.admin.korisnik.KorisnikPage;
import rs.ac.uns.ftn.rezervacije.stranice.admin.let.LetListaPage;
import rs.ac.uns.ftn.rezervacije.stranice.admin.login.PrijavaPage;
import rs.ac.uns.ftn.rezervacije.stranice.admin.lozinka.PromenaLozinkePage;

public abstract class AbstractAdminPage extends AbstractRezervacijaPage {

    private static final long serialVersionUID = 4332673505459326514L;

    public AbstractAdminPage() {
        super();

        if (RezervacijaSession.getSession().isLoggedIn()) {
            if (TipKorisnika.KUPAC.equals(RezervacijaSession.getSession().getKorisnik().getTipKorisnika())) {
                throw new RestartResponseException(PrijavaPage.class);
            }
        } else {
            throw new RestartResponseException(PrijavaPage.class);
        }

        WebMarkupContainer container = new WebMarkupContainer("menu");
        container.add(new BookmarkablePageLink<AvionListaPage>("avioni", AvionListaPage.class));
        container.add(new BookmarkablePageLink<AvionListaPage>("aerodromi", AerodromListaPage.class));
        container.add(new BookmarkablePageLink<AvionListaPage>("korisnici", KorisnikListaPage.class));
        container.add(new BookmarkablePageLink<AvionListaPage>("letovi", LetListaPage.class));

        PageParameters pageParameters = new PageParameters();

        pageParameters.add(Korisnik.ID, RezervacijaSession.getSession().getKorisnik().getId());
        container.add(new BookmarkablePageLink<AvionListaPage>("licnipodaci", KorisnikPage.class, pageParameters));

        container.add(new BookmarkablePageLink<AvionListaPage>("promenaLozinke", PromenaLozinkePage.class));

        container.add(new Link<Void>("odjava") {

            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
                RezervacijaSession.getSession().invalidate();
                setResponsePage(PrijavaPage.class);
            }

        });

        add(container);
    }
}
