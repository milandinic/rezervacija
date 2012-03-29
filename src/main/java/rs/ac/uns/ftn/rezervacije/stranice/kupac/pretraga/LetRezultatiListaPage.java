package rs.ac.uns.ftn.rezervacije.stranice.kupac.pretraga;

import java.util.List;

import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import rs.ac.uns.ftn.rezervacije.RezervacijaSession;
import rs.ac.uns.ftn.rezervacije.model.Let;
import rs.ac.uns.ftn.rezervacije.model.Sediste;
import rs.ac.uns.ftn.rezervacije.model.TipSedista;
import rs.ac.uns.ftn.rezervacije.service.SedisteService;
import rs.ac.uns.ftn.rezervacije.stranice.common.SimpleGridCreator;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.AbstractKupacPage;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.Korak;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.home.HomePage;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.rezervacija.RezervacijaPage;

public class LetRezultatiListaPage extends AbstractKupacPage {

    private static final long serialVersionUID = -820528739421089772L;

    @SpringBean
    private SedisteService sedisteService;

    public LetRezultatiListaPage() {
        super();

        if (!RezervacijaSession.getSession().getKorak().equals(Korak.HOME_PRETRAGA)) {
            throw new RestartResponseAtInterceptPageException(HomePage.class);
        }

        LetRezultatiDataProvider dataProvider = new LetRezultatiDataProvider();

        SimpleGridCreator<Let> simpleGridCreator = new SimpleGridCreator<Let>() {

            @Override
            public void hanldeRowClicked(AjaxRequestTarget target, IModel<Let> rowModel) {
                TipSedista tipSedista = RezervacijaSession.getSession().getPretraga().getPoslovnaKlasa() ? TipSedista.POSLOVNO
                        : TipSedista.EKONOMSKO;

                List<Sediste> rezervisiSediste = sedisteService.rezervisiSediste(rowModel.getObject(),
                        RezervacijaSession.getSession().getKorisnik(), RezervacijaSession.getSession().getPretraga()
                                .getBrojPutnika(), tipSedista);

                RezervacijaSession.getSession().getRezultat().clear();
                RezervacijaSession.getSession().setLet(null);

                if (rezervisiSediste.isEmpty()) {
                    // neko je ukrao sedista
                    // TODO some feedback to user
                    setResponsePage(LetRezultatiListaPage.class);
                } else {
                    RezervacijaSession.getSession().setLet(rowModel.getObject());
                    RezervacijaSession.getSession().getRezultat().addAll(rezervisiSediste);
                    RezervacijaSession.getSession().setKorak(Korak.LISTA_LETOVA);
                    setResponsePage(RezervacijaPage.class);
                }
            }
        };

        simpleGridCreator.addColumnItem("Aerodrom polaska", Let.AERODROM_POLASKA_NAZIV);
        simpleGridCreator.addColumnItem("Aerodrom dolaska", Let.AERODROM_DOLASKA_NAZIV);
        simpleGridCreator.addColumnItem("Sifra", Let.SIFRA);
        simpleGridCreator.addColumnItem("Mesta ekonomska", Let.MESTA_EKONOMSKA);
        simpleGridCreator.addColumnItem("Mesta poslovna", Let.MESTA_POSLOVNA);
        simpleGridCreator.addColumnItem("Cena ekonomska", Let.CENA_EKONOMSKA);
        simpleGridCreator.addColumnItem("Cena poslovna", Let.CENA_POSLOVNA);

        add(simpleGridCreator.createGrid(dataProvider));

    }
}
