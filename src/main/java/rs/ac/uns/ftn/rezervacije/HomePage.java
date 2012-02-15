package rs.ac.uns.ftn.rezervacije;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import rs.ac.uns.ftn.rezervacije.stranice.admin.login.PrijavaPage;

public class HomePage extends WebPage {
    private static final long serialVersionUID = 1L;

    public HomePage(final PageParameters parameters) {
        // TODO Add your page's components here
        add(new BookmarkablePageLink<PrijavaPage>("admin-prijava", PrijavaPage.class));
    }
}
