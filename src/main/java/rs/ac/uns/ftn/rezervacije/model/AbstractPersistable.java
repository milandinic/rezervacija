package rs.ac.uns.ftn.rezervacije.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("serial")
@Configurable
@MappedSuperclass
public abstract class AbstractPersistable implements Serializable {

    @PersistenceContext
    transient EntityManager entityManager;

    public static final String ID = "id";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Version
    @Column(name = "version")
    private Integer version;

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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public static final EntityManager entityManager() {
        // any instance will do
        EntityManager em = new Avion().entityManager;
        if (em == null)
            throw new IllegalStateException(
                    "Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

    public List<? extends AbstractPersistable> findAll() {
        return entityManager().createQuery("SELECT o FROM " + getClass().getSimpleName() + " o", getClass())
                .getResultList();
    }

    @Transactional
    public void persist() {
        if (this.entityManager == null)
            this.entityManager = entityManager();
        this.entityManager.persist(this);
    }

    public AbstractPersistable findById(Long id) {
        if (id == null) {
            return null;
        }
        return entityManager().find(getClass(), id);
    }

    @Transactional
    public void remove() {
        if (this.entityManager == null) {
            this.entityManager = entityManager();
        }
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            AbstractPersistable attached = findById(id);
            this.entityManager.remove(attached);
        }
    }

    @Transactional
    public void flush() {
        if (this.entityManager == null) {
            this.entityManager = entityManager();
        }
        this.entityManager.flush();
    }

    @Transactional
    public void clear() {
        if (this.entityManager == null) {
            this.entityManager = entityManager();
        }
        this.entityManager.clear();
    }

    @Transactional
    public AbstractPersistable merge() {
        if (this.entityManager == null) {
            this.entityManager = entityManager();
        }
        AbstractPersistable merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
