package rs.ac.uns.ftn.rezervacije.stranice.admin.login;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;

import rs.ac.uns.ftn.rezervacije.RezervacijaSession;
import rs.ac.uns.ftn.rezervacije.stranice.AbstractRezervacijaPage;
import rs.ac.uns.ftn.rezervacije.stranice.admin.let.LetListaPage;

public class PrijavaPage extends AbstractRezervacijaPage {

    private static final long serialVersionUID = -5730640245565838705L;

    public PrijavaPage() {
        super();
        add(new FeedbackPanel("feedback"));

        final Kridencijali kridencijali = new Kridencijali();
        Form<Kridencijali> form = new Form<Kridencijali>("form", new CompoundPropertyModel<Kridencijali>(kridencijali)) {
            private static final long serialVersionUID = -5022488816884926557L;

            @Override
            protected void onSubmit() {
                boolean authenticated = RezervacijaSession.getSession().authenticateAdmin(
                        kridencijali.getKorisnickoIme(), kridencijali.getLozinka());
                if (!authenticated) {
                    error("Autentifikacija neuspesna");
                }
                setVisible(!RezervacijaSession.getSession().isLoggedIn());
                setResponsePage(LetListaPage.class);
            }
        };

        form.add(new TextField<String>(Kridencijali.KORISNICKO_IME));
        form.add(new PasswordTextField(Kridencijali.LOZINKA).setResetPassword(true));
        form.add(new Button("submit"));
        add(form);
    }
}
