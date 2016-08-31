package cz.greca.tabor.skladGre.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="sklad", schema="tabor")
public class Sklad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SKLAD_ID_GENERATOR", sequenceName="TABOR.HIBERNATE_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SKLAD_ID_GENERATOR")
	private Long id;

	private Float cena;

	@Temporal(TemporalType.DATE)
	@Column(name="datum_prijmu")
	private Date datumPrijmu;

	@Temporal(TemporalType.DATE)
	@Column(name="datum_vydeje")
	private Date datumVydeje;

	@Column(name="jmeno_potraviny")
	private String jmenoPotraviny;

	@Column(name="merna_jednotka")
	private String mernaJednotka;

	private Float mnozstvi;

	private Integer uctenka;

	//bi-directional many-to-one association to Den
	@ManyToOne
	@JoinColumn(name="id_den")
	private Den den;

	public Sklad() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getCena() {
		return this.cena;
	}

	public void setCena(Float cena) {
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

	public String getJmenoPotraviny() {
		return this.jmenoPotraviny;
	}

	public void setJmenoPotraviny(String jmenoPotraviny) {
		this.jmenoPotraviny = jmenoPotraviny;
	}

	public String getMernaJednotka() {
		return this.mernaJednotka;
	}

	public void setMernaJednotka(String mernaJednotka) {
		this.mernaJednotka = mernaJednotka;
	}

	public Float getMnozstvi() {
		return this.mnozstvi;
	}

	public void setMnozstvi(Float mnozstvi) {
		this.mnozstvi = mnozstvi;
	}

	public Integer getUctenka() {
		return this.uctenka;
	}

	public void setUctenka(Integer uctenka) {
		this.uctenka = uctenka;
	}

	public Den getDen() {
		return this.den;
	}

	public void setDen(Den den) {
		this.den = den;
	}

}