package rs.ac.uns.ftn.rezervacije.stranice.kupac;

import org.apache.wicket.RestartResponseException;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;

import rs.ac.uns.ftn.rezervacije.RezervacijaSession;
import rs.ac.uns.ftn.rezervacije.model.TipKorisnika;
import rs.ac.uns.ftn.rezervacije.stranice.AbstractRezervacijaPage;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.home.HomePage;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.istorija.IstorijaPage;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.licnipodaci.KorisnikKupacPage;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.lozinka.PromenaLozinkeKupacPage;

public abstract class AbstractKupacPage extends AbstractRezervacijaPage {

    private static final long serialVersionUID = 4332673505459326514L;

    public AbstractKupacPage() {
        super();

        boolean home = this instanceof HomePage;

        if (!home) {
            if (RezervacijaSession.getSession().isLoggedIn()) {
                if (TipKorisnika.ADMINISTRATOR.equals(RezervacijaSession.getSession().getKorisnik().getTipKorisnika())) {
                    throw new RestartResponseException(HomePage.class);
                }
            } else {
                throw new RestartResponseException(HomePage.class);
            }
        }

        WebMarkupContainer container = new WebMarkupContainer("menu");

        container.add(new BookmarkablePageLink<HomePage>("pocetna", HomePage.class));
        container.add(new BookmarkablePageLink<KorisnikKupacPage>("licnipodaci", KorisnikKupacPage.class));

        container
                .add(new BookmarkablePageLink<PromenaLozinkeKupacPage>("promenaLozinke", PromenaLozinkeKupacPage.class));
        container.add(new BookmarkablePageLink<IstorijaPage>("istorija", IstorijaPage.class));
        add(container);

        container.add(new Link<Void>("odjava") {

            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
                RezervacijaSession.getSession().invalidate();

            }

            @Override
            public boolean isVisible() {
                return RezervacijaSession.getSession().getKorisnik() != null;
            }
        });

        container.add(new Label("ime", new PropertyModel<String>(this, "session.korisnik.ime")));

    }

}
