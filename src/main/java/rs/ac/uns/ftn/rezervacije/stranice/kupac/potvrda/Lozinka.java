package rs.ac.uns.ftn.rezervacije.stranice.kupac.potvrda;

import java.io.Serializable;

public class Lozinka implements Serializable {

    private static final long serialVersionUID = -697935298391796897L;

    public static final String LOZINKA = "lozinka";
    public static final String PONOVOLJENA_LONZINKA = "ponovoljenaLozinka";

    private String lozinka;
    private String ponovoljenaLozinka;

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getPonovoljenaLozinka() {
        return ponovoljenaLozinka;
    }

    public void setPonovoljenaLozinka(String ponovoljenaLozinka) {
        this.ponovoljenaLozinka = ponovoljenaLozinka;
    }

}
