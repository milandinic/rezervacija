package rs.ac.uns.ftn.rezervacije.stranice.admin.aerodrom;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;

import rs.ac.uns.ftn.rezervacije.model.Aerodrom;
import rs.ac.uns.ftn.rezervacije.service.AerodromService;
import rs.ac.uns.ftn.rezervacije.service.AerodromServiceImpl;
import rs.ac.uns.ftn.rezervacije.stranice.admin.AbstractAdminPage;

public class AerodromPage extends AbstractAdminPage {

    private static final long serialVersionUID = 1L;

    private final AerodromService aerodromService = new AerodromServiceImpl();

    // edit
    public AerodromPage(PageParameters parameters) {
        super();

        FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");

        final Aerodrom avion;
        if (parameters == null) {
            avion = new Aerodrom();
        } else {
            // load
            StringValue stringValue = parameters.get(Aerodrom.ID);
            avion = aerodromService.getById(stringValue.toLong());
        }
        Form<Aerodrom> form = new Form<Aerodrom>("form", new CompoundPropertyModel<Aerodrom>(avion)) {

            private static final long serialVersionUID = 1L;

            @Override
            protected void onSubmit() {
                super.onSubmit();
                aerodromService.create(avion);
            }
        };

        form.add(new TextField<String>(Aerodrom.NAZIV).setRequired(true));

        form.add(new Button("submit"));
        add(form);
        add(feedbackPanel);
    }

    // new
    public AerodromPage() {
        this(null);

    }

}
