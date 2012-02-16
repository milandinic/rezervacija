package rs.ac.uns.ftn.rezervacije.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class AbstractPersistable implements Serializable {

    public static final String ID = "id";

    private Long id;

    public AbstractPersistable() {
        super();
    }

    public AbstractPersistable(Long id) {
        super();
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
