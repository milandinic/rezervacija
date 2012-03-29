package rs.ac.uns.ftn.rezervacije.stranice.kupac.istorija;

import rs.ac.uns.ftn.rezervacije.model.Let;
import rs.ac.uns.ftn.rezervacije.model.Sediste;
import rs.ac.uns.ftn.rezervacije.stranice.common.SimpleGridCreator;
import rs.ac.uns.ftn.rezervacije.stranice.kupac.AbstractKupacPage;

public class IstorijaPage extends AbstractKupacPage {

    private static final long serialVersionUID = -820528739421089772L;

    public IstorijaPage() {
        super();

        IstorijaProvider dataProvider = new IstorijaProvider();

        SimpleGridCreator<Sediste> simpleGridCreator = new SimpleGridCreator<Sediste>();

        simpleGridCreator.addColumnItem("Id", Sediste.ID);
        simpleGridCreator.addColumnItem("Klasa", Sediste.TIP_SEDISTA);

        simpleGridCreator.addColumnItem("Sifra leta", Let.SIFRA);
        simpleGridCreator.addColumnItem("Aerodrom polaska", Let.AERODROM_POLASKA_NAZIV);
        simpleGridCreator.addColumnItem("Aerodrom dolaska", Let.AERODROM_DOLASKA_NAZIV);

        simpleGridCreator.addColumnItem("Cena", Sediste.CENA);

        add(simpleGridCreator.createGrid(dataProvider));
    }

}
