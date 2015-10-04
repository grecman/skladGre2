package cz.greca.tabor.skladGre.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="potravina", schema="tabor")
public class Potravina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="POTRAVINA_ID_GENERATOR", sequenceName="tabor.HIBERNATE_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="POTRAVINA_ID_GENERATOR")
	private long id;

	private String jmeno;

	//bi-directional many-to-one association to Sklad
	@OneToMany(mappedBy="potravina")
	private Set<Sklad> sklads;

	public Potravina() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getJmeno() {
		return this.jmeno;
	}

	public void setJmeno(String jmeno) {
		this.jmeno = jmeno;
	}

	public Set<Sklad> getSklads() {
		return this.sklads;
	}

	public void setSklads(Set<Sklad> sklads) {
		this.sklads = sklads;
	}

	public Sklad addSklad(Sklad sklad) {
		getSklads().add(sklad);
		sklad.setPotravina(this);

		return sklad;
	}

	public Sklad removeSklad(Sklad sklad) {
		getSklads().remove(sklad);
		sklad.setPotravina(null);

		return sklad;
	}

}