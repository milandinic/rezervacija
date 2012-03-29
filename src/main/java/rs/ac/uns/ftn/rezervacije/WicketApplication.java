package rs.ac.uns.ftn.rezervacije;

import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

import rs.ac.uns.ftn.rezervacije.stranice.admin.aerodrom.AerodromListaPage;
import rs.ac.uns.ftn.rezervacije.stranice.admin.aerodrom.AerodromPage;
import rs.ac.uns.ftn.rezervacije.stranice.admin.avion.AvionListaPage;
import rs.ac.uns.ftn.rezervacije.stranice.admin.avion.AvionPage;
import rs.ac.uns.ftn.rezervacije.stranice.admin.korisnik.KorisnikListaPage;
import rs.ac.uns.ftn.rezervacije.stranice.admin.korisnik.KorisnikPage;
import rs.ac.uns.ftn.rezervacije.stranice.admin.let.LetListaPage;
import rs.ac.uns.ftn.rezervacije.stranice.admin.let.LetPage;
import rs.ac.uns.ftn.rezervacije.stranice.admin.login.PrijavaPage;
import rs.ac.uns.ftn.rezervacije.stranice.admin.lozinka.PromenaLozinkePage;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.home.HomePage;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.istorija.IstorijaPage;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.pretraga.LetRezultatiListaPage;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.rezervacija.RezervacijaPage;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see rs.ac.uns.ftn.rezervacije.Start#main(String[])
 */
public class WicketApplication extends WebApplication {

    @Override
    public void init() {
        super.init();

        getComponentInstantiationListeners().add(new SpringComponentInjector(this));

        // getMarkupSettings().setStripXmlDeclarationFromOutput(true);
        getMarkupSettings().setStripWicketTags(true);
        getMarkupSettings().setStripComments(true);

        // addComponentInstantiationListener(new SpringComponentInjector(this));

        mountPage("index.html", HomePage.class);
        mountPage("admin-prijava.html", PrijavaPage.class);

        mountPage("avioni.html", AvionListaPage.class);
        mountPage("avion.html", AvionPage.class);
        mountPage("aerodromi.html", AerodromListaPage.class);
        mountPage("aerodrom.html", AerodromPage.class);

        mountPage("korisnici.html", KorisnikListaPage.class);
        mountPage("korisnik.html", KorisnikPage.class);
        mountPage("letovi.html", LetListaPage.class);
        mountPage("let.html", LetPage.class);
        mountPage("rezultat.html", LetRezultatiListaPage.class);
        mountPage("rezervacija.html", RezervacijaPage.class);
        mountPage("istorija.html", IstorijaPage.class);

        mountPage("promena-lozinke", PromenaLozinkePage.class);

        // add your configuration here

        // getApplicationSettings().setInternalErrorPage(ErrorPage.class);
        // getApplicationSettings().setPageExpiredErrorPage(PageExpired.class);
        // getApplicationSettings().setAccessDeniedPage(ErrorPage.class);
        //
        // getExceptionSettings().setUnexpectedExceptionDisplay(IExceptionSettings.SHOW_INTERNAL_ERROR_PAGE);
    }

    @Override
    public Class<HomePage> getHomePage() {
        return HomePage.class;
    }

    @Override
    public Session newSession(Request request, Response response) {
        return new RezervacijaSession(request);
    }
}
