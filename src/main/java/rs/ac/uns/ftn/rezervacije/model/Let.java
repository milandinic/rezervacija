package rs.ac.uns.ftn.rezervacije.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Let extends AbstractPersistable {

    public static final String AVION = "avion";

    public static final String AERODROM_POLASKA_NAZIV = "aerodromPolaska.naziv";
    public static final String AERODROM_DOLASKA_NAZIV = "aerodromDolaska.naziv";

    public static final String AERODROM_POLASKA = "aerodromPolaska";
    public static final String AERODROM_DOLASKA = "aerodromDolaska";
    public static final String VREME_POLASKA = "vremePolaska";

    public static final String CENA_EKONOMSKA = "cenaEkonomska";
    public static final String CENA_POSLOVNA = "cenaPoslovna";
    public static final String MESTA_EKONOMSKA = "mestaEkonomska";
    public static final String MESTA_POSLOVNA = "mestaPoslovna";
    public static final String SIFRA = "sifra";

    private static final long serialVersionUID = -6450621184738091260L;

    @NotNull
    @ManyToOne
    private Aerodrom aerodromPolaska;

    @NotNull
    @ManyToOne
    private Aerodrom aerodromDolaska;
    @NotNull
    @ManyToOne
    private Avion avion;

    private int cenaEkonomska;
    private int cenaPoslovna;
    private int mestaEkonomska;
    private int mestaPoslovna;
    private String sifra;

    public Let() {
        super();
    }

    public Let(long id, Aerodrom aerodromPolaska, Aerodrom aerodromDolaska, Avion avion) {
        super(id);
        this.aerodromPolaska = aerodromPolaska;
        this.aerodromDolaska = aerodromDolaska;
        this.avion = avion;
    }

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

    public int getCenaEkonomska() {
        return cenaEkonomska;
    }

    public void setCenaEkonomska(int cenaEkonomska) {
        this.cenaEkonomska = cenaEkonomska;
    }

    public int getCenaPoslovna() {
        return cenaPoslovna;
    }

    public void setCenaPoslovna(int cenaPoslovna) {
        this.cenaPoslovna = cenaPoslovna;
    }

    public int getMestaEkonomska() {
        return mestaEkonomska;
    }

    public void setMestaEkonomska(int mestaEkonomska) {
        this.mestaEkonomska = mestaEkonomska;
    }

    public int getMestaPoslovna() {
        return mestaPoslovna;
    }

    public void setMestaPoslovna(int mestaPoslovna) {
        this.mestaPoslovna = mestaPoslovna;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    @Override
    public String toString() {
        return aerodromPolaska.getNaziv() + "-" + aerodromDolaska.getNaziv();
    }
}
