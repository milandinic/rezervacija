package rs.ac.uns.ftn.rezervacije.stranice.admin.aerodrom;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.util.string.StringValue;

import rs.ac.uns.ftn.rezervacije.model.Aerodrom;
import rs.ac.uns.ftn.rezervacije.service.AerodromService;
import rs.ac.uns.ftn.rezervacije.stranice.admin.AbstractAdminPage;

public class AerodromPage extends AbstractAdminPage {

    private static final long serialVersionUID = 1L;

    @SpringBean
    private AerodromService aerodromService;

    // edit
    public AerodromPage(PageParameters parameters) {
        super();

        FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");

        final Aerodrom aerodrom;
        if (parameters == null) {
            aerodrom = new Aerodrom();
        } else {
            // load
            StringValue stringValue = parameters.get(Aerodrom.ID);
            aerodrom = aerodromService.getById(stringValue.toLong());
        }
        Form<Aerodrom> form = new Form<Aerodrom>("form", new CompoundPropertyModel<Aerodrom>(aerodrom)) {

            private static final long serialVersionUID = 1L;

            @Override
            protected void onSubmit() {
                super.onSubmit();
                if (aerodrom.getId() == null) {
                    aerodromService.create(aerodrom);
                } else {
                    aerodromService.update(aerodrom);
                }
                setResponsePage(AerodromListaPage.class);
            }
        };

        form.add(new TextField<String>(Aerodrom.NAZIV).setRequired(true));
        form.add(new TextField<String>(Aerodrom.MESTO).setRequired(true));
        form.add(new TextField<String>(Aerodrom.SIFRA).setRequired(true));

        form.add(new Button("submit"));
        add(form);
        add(feedbackPanel);
    }

    // new
    public AerodromPage() {
        this(null);
    }

}
