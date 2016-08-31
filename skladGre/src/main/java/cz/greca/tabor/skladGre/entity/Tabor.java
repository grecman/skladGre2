package cz.greca.tabor.skladGre.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tabor", schema="tabor")
public class Tabor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TABOR_ID_GENERATOR", sequenceName="TABOR.HIBERNATE_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TABOR_ID_GENERATOR")
	private Long id;

	private String beh;

	private String misto;

	private Integer rok;

	//bi-directional many-to-one association to Den
	@OneToMany(mappedBy="tabor")
	private Set<Den> dens;
	
	//bi-directional many-to-one association to Den
	@OneToMany(mappedBy="tabor")
	private Set<Role> roles;

	public Tabor() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBeh() {
		return this.beh;
	}

	public void setBeh(String beh) {
		this.beh = beh;
	}

	public String getMisto() {
		return this.misto;
	}

	public void setMisto(String misto) {
		this.misto = misto;
	}

	public Integer getRok() {
		return this.rok;
	}

	public void setRok(Integer rok) {
		this.rok = rok;
	}

	public Set<Den> getDens() {
		return this.dens;
	}

	public void setDens(Set<Den> dens) {
		this.dens = dens;
	}

	public Den addDen(Den den) {
		getDens().add(den);
		den.setTabor(this);

		return den;
	}

	public Den removeDen(Den den) {
		getDens().remove(den);
		den.setTabor(null);

		return den;
	}

}