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
	@SequenceGenerator(name="TABOROVYDEN_ID_GENERATOR", sequenceName="tabor.HIBERNATE_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TABOROVYDEN_ID_GENERATOR")
	private long id;

	@Temporal(TemporalType.DATE)
	private Date den;

	private Integer norma;
	
	private Integer poradi;

	@OneToMany(mappedBy="den")
	private Set<Sklad> sklads;
	
	@ManyToOne
	@JoinColumn(name="id_tabor")
	private Tabor tabor;

	public Den() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
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

	public Integer getPoradi() {
		return poradi;
	}

	public void setPoradi(Integer poradi) {
		this.poradi = poradi;
	}
	
	


}