package rs.ac.uns.ftn.rezervacije.model;

public class Let extends AbstractPersistable {

    private static final long serialVersionUID = -6450621184738091260L;

    private Aerodrom aerodromPolaska;
    private Aerodrom aerodromDolaska;
    private Avion avion;

    public Aerodrom getAerodromPolaska() {
        return aerodromPolaska;
    }

    public void setAerodromPolaska(Aerodrom aerodromPolaska) {
        this.aerodromPolaska = aerodromPolaska;
    }

    public Aerodrom getAerodromDolaska() {
        return aerodromDolaska;
    }

    public void setAerodromDolaska(Aerodrom aerodromDolaska) {
        this.aerodromDolaska = aerodromDolaska;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

}
