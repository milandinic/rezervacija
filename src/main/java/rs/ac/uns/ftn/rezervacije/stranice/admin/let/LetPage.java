package rs.ac.uns.ftn.rezervacije.stranice.admin.let;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.util.string.StringValue;
import org.apache.wicket.validation.validator.StringValidator.MaximumLengthValidator;

import rs.ac.uns.ftn.rezervacije.model.Aerodrom;
import rs.ac.uns.ftn.rezervacije.model.Avion;
import rs.ac.uns.ftn.rezervacije.model.Let;
import rs.ac.uns.ftn.rezervacije.service.AerodromService;
import rs.ac.uns.ftn.rezervacije.service.AvionService;
import rs.ac.uns.ftn.rezervacije.service.LetService;
import rs.ac.uns.ftn.rezervacije.stranice.admin.AbstractAdminPage;

public class LetPage extends AbstractAdminPage {

    private static final long serialVersionUID = 1L;

    @SpringBean
    private LetService letService;

    @SpringBean
    private AvionService avionService;

    @SpringBean
    private AerodromService aerodromService;

    // edit
    public LetPage(PageParameters parameters) {
        super();

        FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");

        final Let let;
        if (parameters == null) {
            let = new Let();
        } else {
            // load
            StringValue stringValue = parameters.get(Let.ID);
            let = letService.getById(stringValue.toLong());
        }
        Form<Let> form = new Form<Let>("form", new CompoundPropertyModel<Let>(let)) {

            private static final long serialVersionUID = 1L;

            @Override
            protected void onSubmit() {
                super.onSubmit();

                if (let.getMestaEkonomska() + let.getMestaPoslovna() == let.getAvion().getKapacitet()) {
                    if (let.getId() == null) {
                        letService.create(let);
                    } else {
                        letService.update(let);
                    }
                    setResponsePage(LetListaPage.class);
                } else {
                    error("Broj poslovnih i ekonimskih mesta mora biti jedna kapacitetu aviona.("
                            + let.getAvion().getKapacitet() + ")");
                }

            }
        };
        form.add(new DropDownChoice<Avion>(Let.AVION, avionService.getAll()).setRequired(true));
        form.add(new DropDownChoice<Aerodrom>(Let.AERODROM_POLASKA, aerodromService.getAll()).setRequired(true));
        form.add(new DropDownChoice<Aerodrom>(Let.AERODROM_DOLASKA, aerodromService.getAll()).setRequired(true));

        form.add(new TextField<Integer>(Let.CENA_EKONOMSKA).setRequired(true));
        form.add(new TextField<Integer>(Let.CENA_POSLOVNA).setRequired(true));

        form.add(new TextField<Integer>(Let.MESTA_EKONOMSKA).setRequired(true).setEnabled(let.getId() == null));
        form.add(new TextField<Integer>(Let.MESTA_POSLOVNA).setRequired(true).setEnabled(let.getId() == null));

        form.add(new TextField<String>(Let.SIFRA).setRequired(true).add(new MaximumLengthValidator(10)));

        form.add(new Button("submit"));
        add(form);
        add(feedbackPanel);
    }

    // new
    public LetPage() {
        this(null);

    }

}
