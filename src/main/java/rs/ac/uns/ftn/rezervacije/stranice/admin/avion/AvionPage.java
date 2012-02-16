package rs.ac.uns.ftn.rezervacije.stranice.admin.avion;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;

import rs.ac.uns.ftn.rezervacije.model.Avion;
import rs.ac.uns.ftn.rezervacije.stranice.AbstractRezervacijaPage;

public class AvionPage extends AbstractRezervacijaPage {

    private static final long serialVersionUID = 1L;

    public AvionPage() {
        super();
        FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");

        Form<Avion> form = new Form<Avion>("form", new CompoundPropertyModel<Avion>(new Avion())) {

            private static final long serialVersionUID = 1L;

            @Override
            protected void onSubmit() {
                // TODO Auto-generated method stub
                super.onSubmit();
            }
        };

        form.add(new TextField<String>(Avion.NAZIV).setRequired(true));
        form.add(new TextField<Integer>(Avion.KAPACITET).setRequired(true));

        form.add(new Button("submit"));
        add(form);
        add(feedbackPanel);
    }

}
