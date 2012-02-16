package rs.ac.uns.ftn.rezervacije.stranice.admin.avion;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;

import rs.ac.uns.ftn.rezervacije.model.Avion;
import rs.ac.uns.ftn.rezervacije.service.AeroplaneService;
import rs.ac.uns.ftn.rezervacije.service.AeroplaneServiceImpl;
import rs.ac.uns.ftn.rezervacije.stranice.AbstractRezervacijaPage;

public class AvionPage extends AbstractRezervacijaPage {

    private static final long serialVersionUID = 1L;

    private final AeroplaneService aeroplaneService = new AeroplaneServiceImpl();

    // edit
    public AvionPage(PageParameters parameters) {
        super();

        FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");

        final Avion avion;
        if (parameters == null) {
            avion = new Avion();
        } else {
            // load
            StringValue stringValue = parameters.get(ID);
            avion = aeroplaneService.getById(stringValue.toLong());
        }
        Form<Avion> form = new Form<Avion>("form", new CompoundPropertyModel<Avion>(avion)) {

            private static final long serialVersionUID = 1L;

            @Override
            protected void onSubmit() {
                super.onSubmit();
                aeroplaneService.create(avion);
            }
        };

        form.add(new TextField<String>(Avion.NAZIV).setRequired(true));
        form.add(new TextField<Integer>(Avion.KAPACITET).setRequired(true));

        form.add(new Button("submit"));
        add(form);
        add(feedbackPanel);
    }

    // new
    public AvionPage() {
        this(null);

    }

}
