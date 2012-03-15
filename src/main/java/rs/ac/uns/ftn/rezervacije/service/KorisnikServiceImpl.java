package rs.ac.uns.ftn.rezervacije.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.rezervacije.model.Korisnik;

@Service
class KorisnikServiceImpl implements KorisnikService, Serializable {

    private static final long serialVersionUID = 1L;

    private final List<Korisnik> list = new ArrayList<Korisnik>();

    public KorisnikServiceImpl() {
        super();
        list.add(new Korisnik(1, "Pera", "Peric", "a", "a"));
        list.add(new Korisnik(2, "Ana", "Anic", "b", "b"));
        list.add(new Korisnik(3, "Ceda", "Cedic", "c", "c"));
    }

    public void create(Korisnik object) {
        // TODO Auto-generated method stub

    }

    public void deleteById(long id) {
        // TODO Auto-generated method stub

    }

    public Korisnik getById(long id) {
        return list.get(0);
    }

    public List<Korisnik> getAll() {
        return list;
    }

    public int countAll() {
        return list.size();
    }

    public void update(Korisnik object) {
        // TODO Auto-generated method stub

    }

}
