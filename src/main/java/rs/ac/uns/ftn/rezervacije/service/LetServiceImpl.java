package rs.ac.uns.ftn.rezervacije.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.rezervacije.dao.AbstractDao;
import rs.ac.uns.ftn.rezervacije.dao.LetDao;
import rs.ac.uns.ftn.rezervacije.model.Let;

@Service
class LetServiceImpl extends ICRUDImpl<Let> implements LetService, Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private LetDao letDao;

    @Override
    protected AbstractDao<Let> getDao() {
        return letDao;
    }

}
