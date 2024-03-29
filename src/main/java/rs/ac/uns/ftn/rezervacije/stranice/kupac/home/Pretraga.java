package rs.ac.uns.ftn.rezervacije.stranice.kupac.home;

import java.io.Serializable;

import rs.ac.uns.ftn.rezervacije.model.Aerodrom;

public class Pretraga implements Serializable {

    private static final long serialVersionUID = 7966816711833038152L;

    public static final String POSLOVNA_KLASA = "poslovnaKlasa";
    public static final String BROJ_PUTNIKA = "brojPutnika";
    public static final String AERODROM_POLASKA = "aerodromPolaska";
    public static final String AERODROM_DOLASKA = "aerodromDolaska";

    private Aerodrom aerodromPolaska;
    private Aerodrom aerodromDolaska;
    private Boolean poslovnaKlasa = false;
    private Long brojPutnika = 1L;

    public Long getBrojPutnika() {
        return brojPutnika;
    }

    public void setBrojPutnika(Long brojPutnika) {
        this.brojPutnika = brojPutnika;
    }

    public Boolean getPoslovnaKlasa() {
        return poslovnaKlasa;
    }

    public void setPoslovnaKlasa(Boolean poslovnaKlasa) {
        this.poslovnaKlasa = poslovnaKlasa;
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

}
