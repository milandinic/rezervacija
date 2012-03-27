package rs.ac.uns.ftn.rezervacije.stranice.kupac.pretraga;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

import rs.ac.uns.ftn.rezervacije.RezervacijaSession;
import rs.ac.uns.ftn.rezervacije.model.Let;
import rs.ac.uns.ftn.rezervacije.model.TipSedista;
import rs.ac.uns.ftn.rezervacije.service.SedisteService;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.AbstractKupacPage;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.Korak;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.home.HomePage;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.rezervacija.RezervacijaPage;

import com.inmethod.grid.DataProviderAdapter;
import com.inmethod.grid.IGridColumn;
import com.inmethod.grid.column.PropertyColumn;
import com.inmethod.grid.datagrid.DataGrid;
import com.inmethod.grid.datagrid.DefaultDataGrid;

public class LetRezultatiListaPage extends AbstractKupacPage {

    private static final long serialVersionUID = -820528739421089772L;

    @SpringBean
    private SedisteService sedisteService;

    public LetRezultatiListaPage() {
        super();

        if (!RezervacijaSession.getSession().getKorak().equals(Korak.HOME_PRETRAGA)) {
            throw new RestartResponseAtInterceptPageException(HomePage.class);
        }

        LetRezultatiDataProvider dataProvider = new LetRezultatiDataProvider();

        List<IGridColumn> cols = (List) Arrays.asList(new PropertyColumn(new Model("Aerodrom polaska"),
                Let.AERODROM_POLASKA_NAZIV), new PropertyColumn(new Model("Aerodrom dolaska"),
                Let.AERODROM_DOLASKA_NAZIV), new PropertyColumn(new Model("Sifra"), Let.SIFRA), new PropertyColumn(
                new Model("Mesta ekonomska"), Let.MESTA_EKONOMSKA), new PropertyColumn(new Model("Mesta poslovna"),
                Let.MESTA_POSLOVNA), new PropertyColumn(new Model("Cena poslovna"), Let.CENA_POSLOVNA),
                new PropertyColumn(new Model("Cena ekonomska"), Let.CENA_EKONOMSKA));

        DataGrid grid = new DefaultDataGrid("grid", new DataProviderAdapter<Let>(dataProvider), cols) {

            private static final long serialVersionUID = -2388101643712962470L;

            @Override
            protected void onRowClicked(AjaxRequestTarget target, IModel rowModel) {
                super.onRowClicked(target, rowModel);

                TipSedista tipSedista = RezervacijaSession.getSession().getPretraga().getPoslovnaKlasa() ? TipSedista.POSLOVNO
                        : TipSedista.EKONOMSKO;

                sedisteService.rezervisiSediste((Let) rowModel.getObject(), RezervacijaSession.getSession()
                        .getKorisnik(), RezervacijaSession.getSession().getPretraga().getBrojPutnika(), tipSedista);

                RezervacijaSession.getSession().setKorak(Korak.LISTA_LETOVA);

                setResponsePage(RezervacijaPage.class);
            }
        };
        add(grid);

    }
}
