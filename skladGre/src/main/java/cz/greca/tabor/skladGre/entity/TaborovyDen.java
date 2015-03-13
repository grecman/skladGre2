package cz.greca.tabor.skladGre.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the "TaborovyDen" database table.
 * 
 */
@Entity
@Table(name="\"TaborovyDen\"")
public class TaborovyDen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TABOROVYDEN_ID_GENERATOR", sequenceName="HIBERNATE_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TABOROVYDEN_ID_GENERATOR")
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date den;

	private Integer norma;

	//bi-directional many-to-one association to Sklad
	@OneToMany(mappedBy="taborovyDen")
	private Set<Sklad> sklads;

	public TaborovyDen() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDen() {
		return this.den;
	}

	public void setDen(Date den) {
		this.den = den;
	}

	public Integer getNorma() {
		return this.norma;
	}

	public void setNorma(Integer norma) {
		this.norma = norma;
	}

	public Set<Sklad> getSklads() {
		return this.sklads;
	}

	public void setSklads(Set<Sklad> sklads) {
		this.sklads = sklads;
	}

	public Sklad addSklad(Sklad sklad) {
		getSklads().add(sklad);
		sklad.setTaborovyDen(this);

		return sklad;
	}

	public Sklad removeSklad(Sklad sklad) {
		getSklads().remove(sklad);
		sklad.setTaborovyDen(null);

		return sklad;
	}

}