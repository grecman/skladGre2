package cz.greca.tabor.skladGre.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="sklad", schema="tabor")
public class Sklad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SKLAD_ID_GENERATOR", sequenceName="tabor.HIBERNATE_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SKLAD_ID_GENERATOR")
	private long id;

	private Float cena;
	
	private Float mnozstvi;

	@Temporal(TemporalType.DATE)
	@Column(name="datum_prijmu")
	private Date datumPrijmu;

	@Temporal(TemporalType.DATE)
	@Column(name="datum_vydeje")
	private Date datumVydeje;

	private Integer uctenka;

	//bi-directional many-to-one association to Potravina
	@ManyToOne
	@JoinColumn(name="id_potravina")
	private Potravina potravina;

	//bi-directional many-to-one association to TaborovyDen
	@ManyToOne
	@JoinColumn(name="id_den")
	private Den den;
	
	@ManyToOne
	@JoinColumn(name="id_mj")
	private Mj mj;

	public Sklad() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Float getCena() {
		return cena;
	}

	public void setCena(Float cena) {
		this.cena = cena;
	}

	public Float getMnozstvi() {
		return mnozstvi;
	}

	public void setMnozstvi(Float mnozstvi) {
		this.mnozstvi = mnozstvi;
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

	public Den getDen() {
		return den;
	}

	public void setDen(Den den) {
		this.den = den;
	}

	public Mj getMj() {
		return mj;
	}

	public void setMj(Mj mj) {
		this.mj = mj;
	}



}