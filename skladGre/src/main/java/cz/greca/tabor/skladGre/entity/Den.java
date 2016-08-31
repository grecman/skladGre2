package cz.greca.tabor.skladGre.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="den", schema="tabor")
public class Den implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEN_ID_GENERATOR", sequenceName="TABOR.HIBERNATE_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEN_ID_GENERATOR")
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date den;

	private Integer norma;

	private Integer poradi;

	//bi-directional many-to-one association to Tabor
	@ManyToOne
	@JoinColumn(name="id_tabor")
	private Tabor tabor;

	//bi-directional many-to-one association to Sklad
	@OneToMany(mappedBy="den")
	private Set<Sklad> sklads;

	public Den() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
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

	public Integer getPoradi() {
		return this.poradi;
	}

	public void setPoradi(Integer poradi) {
		this.poradi = poradi;
	}

	public Tabor getTabor() {
		return this.tabor;
	}

	public void setTabor(Tabor tabor) {
		this.tabor = tabor;
	}

	public Set<Sklad> getSklads() {
		return this.sklads;
	}

	public void setSklads(Set<Sklad> sklads) {
		this.sklads = sklads;
	}

	public Sklad addSklad(Sklad sklad) {
		getSklads().add(sklad);
		sklad.setDen(this);

		return sklad;
	}

	public Sklad removeSklad(Sklad sklad) {
		getSklads().remove(sklad);
		sklad.setDen(null);

		return sklad;
	}

}