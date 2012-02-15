package rs.ac.uns.ftn.rezervacije.model;

public class Sediste extends AbstractPersistable {

	private Let let;
	private Korisnik korisnik;

	public Let getLet() {
		return let;
	}

	public void setLet(Let let) {
		this.let = let;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

}
