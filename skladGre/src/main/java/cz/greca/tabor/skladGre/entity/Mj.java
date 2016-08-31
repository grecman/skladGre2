package cz.greca.tabor.skladGre.entity;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="mj", schema="tabor")
public class Mj implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MJ_ID_GENERATOR", sequenceName="TABOR.HIBERNATE_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MJ_ID_GENERATOR")
	private Long id;

	@Column(name="merna_jednotka")
	private String mernaJednotka;

	private String popis;

	public Mj() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMernaJednotka() {
		return this.mernaJednotka;
	}

	public void setMernaJednotka(String mernaJednotka) {
		this.mernaJednotka = mernaJednotka;
	}

	public String getPopis() {
		return this.popis;
	}

	public void setPopis(String popis) {
		this.popis = popis;
	}

}