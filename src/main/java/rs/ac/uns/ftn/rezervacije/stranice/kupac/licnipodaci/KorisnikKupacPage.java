package rs.ac.uns.ftn.rezervacije.stranice.kupac.licnipodaci;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import rs.ac.uns.ftn.rezervacije.RezervacijaSession;
import rs.ac.uns.ftn.rezervacije.model.Korisnik;
import rs.ac.uns.ftn.rezervacije.service.KorisnikService;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.AbstractKupacPage;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.home.HomePage;

public class KorisnikKupacPage extends AbstractKupacPage {

    private static final long serialVersionUID = 1L;

    @SpringBean
    private KorisnikService korisnikService;

    public KorisnikKupacPage() {
        super();

        FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");

        final Korisnik korisnik = RezervacijaSession.getSession().getKorisnik();
        Form<Korisnik> form = new Form<Korisnik>("form", new CompoundPropertyModel<Korisnik>(korisnik)) {

            private static final long serialVersionUID = 1L;

            @Override
            protected void onSubmit() {
                super.onSubmit();

                Korisnik korisnikByKorisnickoIme = korisnikService.getByKorisnickoIme(korisnik.getKorisnickoIme());
                if (korisnikByKorisnickoIme == null) {
                    korisnikService.update(korisnik);
                } else if (korisnikByKorisnickoIme.getId().equals(korisnik.getId())) {
                    korisnikService.update(korisnik);
                } else {
                    error("Korisnicko ime je zauzeto.");
                    return;
                }

                setResponsePage(HomePage.class);
            }
        };

        form.add(new TextField<String>(Korisnik.IME).setRequired(true));
        form.add(new TextField<String>(Korisnik.PREZIME).setRequired(true));
        form.add(new TextField<String>(Korisnik.KORISNICKO_IME).setRequired(true));

        form.add(new Button("submit"));
        add(form);
        add(feedbackPanel);
    }

}
