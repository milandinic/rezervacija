package rs.ac.uns.ftn.rezervacije.model;

abstract class AbstractPersistable {

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
