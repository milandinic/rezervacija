package rs.ac.uns.ftn.rezervacije.stranice.kupac.istorija;

import rs.ac.uns.ftn.rezervacije.model.Let;
import rs.ac.uns.ftn.rezervacije.model.Sediste;
import rs.ac.uns.ftn.rezervacije.stranice.admin.AbstractAdminPage;
import rs.ac.uns.ftn.rezervacije.stranice.common.SimpleGridCreator;

public class IstorijaPage extends AbstractAdminPage {

    private static final long serialVersionUID = -820528739421089772L;

    public IstorijaPage() {
        super();

        IstorijaProvider dataProvider = new IstorijaProvider();

        SimpleGridCreator<Sediste> simpleGridCreator = new SimpleGridCreator<Sediste>();

        simpleGridCreator.addColumnItem("Aerodrom polaska", Let.AERODROM_POLASKA_NAZIV);
        simpleGridCreator.addColumnItem("Aerodrom dolaska", Let.AERODROM_DOLASKA_NAZIV);
        simpleGridCreator.addColumnItem("Sifra", Let.SIFRA);
        simpleGridCreator.addColumnItem("Mesta ekonomska", Let.MESTA_EKONOMSKA);
        simpleGridCreator.addColumnItem("Mesta poslovna", Let.MESTA_POSLOVNA);
        simpleGridCreator.addColumnItem("Cena ekonomska", Let.CENA_EKONOMSKA);
        simpleGridCreator.addColumnItem("Cena poslovna", Let.CENA_POSLOVNA);

        add(simpleGridCreator.createGrid(dataProvider));
    }

}
