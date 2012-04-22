package rs.ac.uns.ftn.rezervacije.stranice.admin.lozinka;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.springframework.beans.factory.annotation.Autowired;

import rs.ac.uns.ftn.rezervacije.RezervacijaSession;
import rs.ac.uns.ftn.rezervacije.service.KorisnikService;
import rs.ac.uns.ftn.rezervacije.stranice.admin.AbstractAdminPage;

public class PromenaLozinkePage extends AbstractAdminPage {

    private static final long serialVersionUID = -5730640245565838705L;

    @Autowired
    private KorisnikService korisnikService;

    public PromenaLozinkePage() {
        super();

        final Lozinka lozinka = new Lozinka();
        Form<Lozinka> form = new Form<Lozinka>("form", new CompoundPropertyModel<Lozinka>(lozinka)) {
            private static final long serialVersionUID = -5022488816884926557L;

            @Override
            protected void onSubmit() {
                if (lozinka.getLozinka().equals(lozinka.getPonovoljenaLozinka())) {
                    RezervacijaSession.getSession().getKorisnik().setLozinka(lozinka.getLozinka());
                    korisnikService.update(RezervacijaSession.getSession().getKorisnik());
                } else {
                    error("Lozinka i ponovoljena lozinka nisu iste.");
                }

            }
        };
        add(new FeedbackPanel("feedback"));

        form.add(new PasswordTextField(Lozinka.LOZINKA).setResetPassword(true).setRequired(true));
        form.add(new PasswordTextField(Lozinka.PONOVOLJENA_LONZINKA).setResetPassword(true).setRequired(true));
        form.add(new Button("submit"));
        add(form);
    }
}
