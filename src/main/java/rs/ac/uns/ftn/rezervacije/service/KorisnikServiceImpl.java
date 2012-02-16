package rs.ac.uns.ftn.rezervacije.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.ftn.rezervacije.model.Korisnik;

public class KorisnikServiceImpl implements KorisnikService, Serializable {

    private static final long serialVersionUID = 1L;

    private final List<Korisnik> list = new ArrayList<Korisnik>();

    public KorisnikServiceImpl() {
        super();
        list.add(new Korisnik("Pera", "a", "a", 1L));
        list.add(new Korisnik("Ana", "b", "b", 2L));
        list.add(new Korisnik("Ceda", "c", "c", 3L));
    }

    public void create(Korisnik object) {
        // TODO Auto-generated method stub

    }

    public void deleteById(long id) {
        // TODO Auto-generated method stub

    }

    public Korisnik getById(long id) {
        return new Korisnik("NOvi", "d", "d", id);
    }

    public List<Korisnik> getAll() {
        return list;
    }

    public int countAll() {
        return list.size();
    }

}
