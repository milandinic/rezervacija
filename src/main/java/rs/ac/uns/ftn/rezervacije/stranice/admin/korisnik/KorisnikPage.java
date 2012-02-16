package rs.ac.uns.ftn.rezervacije.stranice.admin.korisnik;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;

import rs.ac.uns.ftn.rezervacije.model.Korisnik;
import rs.ac.uns.ftn.rezervacije.service.KorisnikService;
import rs.ac.uns.ftn.rezervacije.service.KorisnikServiceImpl;
import rs.ac.uns.ftn.rezervacije.stranice.admin.AbstractAdminPage;

public class KorisnikPage extends AbstractAdminPage {

    private static final long serialVersionUID = 1L;

    private final KorisnikService korisnikService = new KorisnikServiceImpl();

    // edit
    public KorisnikPage(PageParameters parameters) {
        super();

        FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");

        final Korisnik korisnik;
        if (parameters == null) {
            korisnik = new Korisnik();
        } else {
            // load
            StringValue stringValue = parameters.get(Korisnik.ID);
            korisnik = korisnikService.getById(stringValue.toLong());
        }
        Form<Korisnik> form = new Form<Korisnik>("form", new CompoundPropertyModel<Korisnik>(korisnik)) {

            private static final long serialVersionUID = 1L;

            @Override
            protected void onSubmit() {
                super.onSubmit();
                korisnikService.create(korisnik);
            }
        };

        form.add(new TextField<String>(Korisnik.IME).setRequired(true));
        form.add(new TextField<String>(Korisnik.KORISNICKO_IME).setRequired(true));

        form.add(new Button("submit"));
        add(form);
        add(feedbackPanel);
    }

    // new
    public KorisnikPage() {
        this(null);

    }

}
