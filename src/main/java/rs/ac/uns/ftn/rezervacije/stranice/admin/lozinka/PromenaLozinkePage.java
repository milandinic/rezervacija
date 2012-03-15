package rs.ac.uns.ftn.rezervacije.stranice.admin.lozinka;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.model.CompoundPropertyModel;

import rs.ac.uns.ftn.rezervacije.stranice.admin.AbstractAdminPage;

public class PromenaLozinkePage extends AbstractAdminPage {

    private static final long serialVersionUID = -5730640245565838705L;

    public PromenaLozinkePage() {
        super();

        Form<Lozinka> form = new Form<Lozinka>("form", new CompoundPropertyModel<Lozinka>(new Lozinka())) {
            private static final long serialVersionUID = -5022488816884926557L;

            @Override
            protected void onSubmit() {

                super.onSubmit();
            }
        };

        form.add(new PasswordTextField(Lozinka.LOZINKA).setResetPassword(true));
        form.add(new PasswordTextField(Lozinka.PONOVOLJENA_LONZINKA).setResetPassword(true));
        form.add(new Button("submit"));
        add(form);
    }
}
