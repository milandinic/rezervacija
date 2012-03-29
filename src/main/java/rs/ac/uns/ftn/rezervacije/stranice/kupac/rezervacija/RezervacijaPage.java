package rs.ac.uns.ftn.rezervacije.stranice.kupac.rezervacija;

import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.CompoundPropertyModel;

import rs.ac.uns.ftn.rezervacije.RezervacijaSession;
import rs.ac.uns.ftn.rezervacije.model.Let;
import rs.ac.uns.ftn.rezervacije.model.Sediste;
import rs.ac.uns.ftn.rezervacije.stranice.common.SimpleGridCreator;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.AbstractKupacPage;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.Korak;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.home.HomePage;

public class RezervacijaPage extends AbstractKupacPage {

    private static final long serialVersionUID = -1550978776316588651L;

    public RezervacijaPage() {
        super();

        if (!RezervacijaSession.getSession().getKorak().equals(Korak.LISTA_LETOVA)) {
            throw new RestartResponseAtInterceptPageException(HomePage.class);
        }
        RezervacijaSession.getSession().setKorak(Korak.NONE);

        WebMarkupContainer container = new WebMarkupContainer("let");
        container.setDefaultModel(new CompoundPropertyModel<Let>(RezervacijaSession.getSession().getLet()));
        add(container);
        container.add(new Label(Let.SIFRA));
        container.add(new Label(Let.AVION));
        container.add(new Label(Let.AERODROM_DOLASKA_NAZIV));
        container.add(new Label(Let.AERODROM_POLASKA_NAZIV));

        SedistaDataProvider dataProvider = new SedistaDataProvider();

        SimpleGridCreator<Sediste> simpleGridCreator = new SimpleGridCreator<Sediste>();

        simpleGridCreator.addColumnItem("ID", Sediste.ID);
        simpleGridCreator.addColumnItem("Klasa", Sediste.TIP_SEDISTA);

        add(simpleGridCreator.createGrid(dataProvider));

        add(new BookmarkablePageLink<HomePage>("homePage", HomePage.class));
    }

}
