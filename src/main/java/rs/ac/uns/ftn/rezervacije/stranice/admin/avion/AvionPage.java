package rs.ac.uns.ftn.rezervacije.stranice.admin.avion;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.util.string.StringValue;

import rs.ac.uns.ftn.rezervacije.model.Avion;
import rs.ac.uns.ftn.rezervacije.service.AvionService;
import rs.ac.uns.ftn.rezervacije.stranice.admin.AbstractAdminPage;

public class AvionPage extends AbstractAdminPage {

    private static final long serialVersionUID = 1L;

    @SpringBean
    private AvionService aeroplaneService;

    // edit
    public AvionPage(PageParameters parameters) {
        super();

        FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");

        final Avion avion;
        if (parameters == null) {
            avion = new Avion();
        } else {
            // load
            StringValue stringValue = parameters.get(Avion.ID);
            avion = aeroplaneService.getById(stringValue.toLong());
        }
        Form<Avion> form = new Form<Avion>("form", new CompoundPropertyModel<Avion>(avion)) {

            private static final long serialVersionUID = 1L;

            @Override
            protected void onSubmit() {
                super.onSubmit();
                if (avion.getId() == null) {
                    aeroplaneService.create(avion);
                } else {
                    aeroplaneService.update(avion);
                }
            }
        };

        form.add(new TextField<String>(Avion.MODEL).setRequired(true));
        form.add(new TextField<String>(Avion.PROIZVODJAC).setRequired(true));
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
