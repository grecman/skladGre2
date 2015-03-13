package cz.greca.tabor.skladGre.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "Sklad" database table.
 * 
 */
@Entity
@Table(name="\"Sklad\"")
public class Sklad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SKLAD_ID_GENERATOR", sequenceName="HIBERNATE_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SKLAD_ID_GENERATOR")
	private Integer id;

	private float cena;

	@Temporal(TemporalType.DATE)
	@Column(name="\"datumPrijmu\"")
	private Date datumPrijmu;

	@Temporal(TemporalType.DATE)
	@Column(name="\"datumVydeje\"")
	private Date datumVydeje;

	private Integer uctenka;

	//bi-directional many-to-one association to Potravina
	@ManyToOne
	@JoinColumn(name="id_potravina")
	private Potravina potravina;

	//bi-directional many-to-one association to TaborovyDen
	@ManyToOne
	@JoinColumn(name="id_den")
	private TaborovyDen taborovyDen;

	public Sklad() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getCena() {
		return this.cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}

	public Date getDatumPrijmu() {
		return this.datumPrijmu;
	}

	public void setDatumPrijmu(Date datumPrijmu) {
		this.datumPrijmu = datumPrijmu;
	}

	public Date getDatumVydeje() {
		return this.datumVydeje;
	}

	public void setDatumVydeje(Date datumVydeje) {
		this.datumVydeje = datumVydeje;
	}

	public Integer getUctenka() {
		return this.uctenka;
	}

	public void setUctenka(Integer uctenka) {
		this.uctenka = uctenka;
	}

	public Potravina getPotravina() {
		return this.potravina;
	}

	public void setPotravina(Potravina potravina) {
		this.potravina = potravina;
	}

	public TaborovyDen getTaborovyDen() {
		return this.taborovyDen;
	}

	public void setTaborovyDen(TaborovyDen taborovyDen) {
		this.taborovyDen = taborovyDen;
	}

}