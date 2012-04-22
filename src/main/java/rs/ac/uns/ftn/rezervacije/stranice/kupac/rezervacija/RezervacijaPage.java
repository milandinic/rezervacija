package rs.ac.uns.ftn.rezervacije.stranice.kupac.rezervacija;

import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import rs.ac.uns.ftn.rezervacije.RezervacijaSession;
import rs.ac.uns.ftn.rezervacije.model.Let;
import rs.ac.uns.ftn.rezervacije.model.Sediste;
import rs.ac.uns.ftn.rezervacije.service.SedisteService;
import rs.ac.uns.ftn.rezervacije.stranice.common.SimpleGridCreator;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.AbstractKupacPage;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.Korak;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.home.HomePage;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.potvrda.PotvrdaPage;

public class RezervacijaPage extends AbstractKupacPage {

    private static final long serialVersionUID = -1550978776316588651L;

    @SpringBean
    private SedisteService sedisteService;

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

        add(new Link<Void>("potvrda") {

            private static final long serialVersionUID = 6045767308930551472L;

            @Override
            public void onClick() {
                // TODO Auto-generated method stub
                sedisteService.potvrdiRezervacije(RezervacijaSession.getSession().getKorisnik(), RezervacijaSession
                        .getSession().getRezultat());

                setResponsePage(PotvrdaPage.class);
            }

        });

        add(new Link<Void>("odustani") {

            private static final long serialVersionUID = 6366304945881455953L;

            @Override
            public void onClick() {

                sedisteService.ponistiRezervacije(RezervacijaSession.getSession().getKorisnik());
                setResponsePage(HomePage.class);

            }

        });

    }

}
