package cz.greca.tabor.skladGre.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;


/**
 * The persistent class for the tabor database table.
 * 
 */
@Entity
@Table(name="tabor", schema="tabor")
public class Tabor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TABOR_ID_GENERATOR", sequenceName="tabor.HIBERNATE_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TABOR_ID_GENERATOR")
	private Long id;

	private String beh;

	private String misto;

	private Integer rok;
	
	private String role;
	
	@OneToMany(mappedBy="tabor")
	private Set<Den> dens;
	
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;
	
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<Den> getDens() {
		return dens;
	}

	public void setDens(Set<Den> dens) {
		this.dens = dens;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}