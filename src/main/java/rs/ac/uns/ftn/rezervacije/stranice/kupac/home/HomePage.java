package rs.ac.uns.ftn.rezervacije.stranice.kupac.home;

import java.util.Arrays;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import rs.ac.uns.ftn.rezervacije.RezervacijaSession;
import rs.ac.uns.ftn.rezervacije.model.Aerodrom;
import rs.ac.uns.ftn.rezervacije.service.AerodromService;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.AbstractKupacPage;

public class HomePage extends AbstractKupacPage {

    private static final long serialVersionUID = -5730640245565838705L;

    @SpringBean
    private AerodromService aerodromService;

    public HomePage() {
        super();
        add(new FeedbackPanel("feedback"));

        final Kridencijali kridencijali = new Kridencijali();
        final Form<Kridencijali> form = new Form<Kridencijali>("form", new CompoundPropertyModel<Kridencijali>(
                kridencijali)) {
            private static final long serialVersionUID = -5022488816884926557L;

            @Override
            protected void onSubmit() {

                boolean authenticated = RezervacijaSession.getSession().authenticate(kridencijali.getKorisnickoIme(),
                        kridencijali.getLozinka());
                if (!authenticated) {
                    error("Autentifikacija neuspesna");
                }
                setVisible(!RezervacijaSession.getSession().isLoggedIn());
            }
        };

        form.add(new TextField<String>(Kridencijali.KORISNICKO_IME).setRequired(true));
        form.add(new PasswordTextField(Kridencijali.LOZINKA).setResetPassword(true).setRequired(true));
        form.add(new Button("submit"));
        add(form);

        form.setVisible(!RezervacijaSession.getSession().isLoggedIn());

        Form<Pretraga> search = new Form<Pretraga>("search", new CompoundPropertyModel<Pretraga>(new Pretraga())) {

            private static final long serialVersionUID = 8879620429216322519L;

            @Override
            protected void onSubmit() {
                if (!RezervacijaSession.getSession().isLoggedIn()) {
                    error("Prijava je neophodna.");
                    return;
                }
                super.onSubmit();
            }
        };

        search.add(new DropDownChoice<Aerodrom>(Pretraga.AERODROM_POLASKA, aerodromService.getAll()).setRequired(true));
        search.add(new DropDownChoice<Aerodrom>(Pretraga.AERODROM_DOLASKA, aerodromService.getAll()).setRequired(true));

        search.add(new CheckBox(Pretraga.POVRATNA));
        search.add(new CheckBox(Pretraga.POSLOVNA_KLASA));
        search.add(new DropDownChoice<Integer>(Pretraga.BROJ_PUTNIKA, Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 })));
        search.add(new Button("submit"));
        add(search);
    }
}
