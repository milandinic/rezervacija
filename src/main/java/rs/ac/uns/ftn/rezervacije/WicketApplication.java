package rs.ac.uns.ftn.rezervacije;

import org.apache.wicket.protocol.http.WebApplication;

import rs.ac.uns.ftn.rezervacije.stranice.admin.avion.AvionListaPage;
import rs.ac.uns.ftn.rezervacije.stranice.admin.login.PrijavaPage;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see rs.ac.uns.ftn.rezervacije.Start#main(String[])
 */
public class WicketApplication extends WebApplication {
    @Override
    public Class<HomePage> getHomePage() {
        return HomePage.class;
    }

    @Override
    public void init() {
        super.init();

        // getMarkupSettings().setStripXmlDeclarationFromOutput(true);
        getMarkupSettings().setStripWicketTags(true);
        getMarkupSettings().setStripComments(true);

        // addComponentInstantiationListener(new SpringComponentInjector(this));

        mountPage("home", HomePage.class);
        mountPage("admin-prijava", PrijavaPage.class);
        mountPage("avioni", AvionListaPage.class);
        // add your configuration here

        // getApplicationSettings().setInternalErrorPage(ErrorPage.class);
        // getApplicationSettings().setPageExpiredErrorPage(PageExpired.class);
        // getApplicationSettings().setAccessDeniedPage(ErrorPage.class);
        //
        // getExceptionSettings().setUnexpectedExceptionDisplay(IExceptionSettings.SHOW_INTERNAL_ERROR_PAGE);
    }
}
