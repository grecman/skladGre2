package cz.greca.tabor.skladGre.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="user", schema="tabor")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USERS_ID_GENERATOR", sequenceName="tabor.HIBERNATE_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERS_ID_GENERATOR")
	private long id;

	private String nick;

	private String password;

	@Column(name="pocet_prihlaseni")
	private Integer pocetPrihlaseni;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="posledni_prihlaseni")
	private Date posledniPrihlaseni;
	
	@Column(name="super_admin")
	private Boolean superAdmin;
		
	@OneToMany(mappedBy="user")
	private Set<Tabor> tabors;
	
	public User() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNick() {
		return this.nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPocetPrihlaseni() {
		return this.pocetPrihlaseni;
	}

	public void setPocetPrihlaseni(Integer pocetPrihlaseni) {
		this.pocetPrihlaseni = pocetPrihlaseni;
	}

	public Date getPosledniPrihlaseni() {
		return this.posledniPrihlaseni;
	}

	public void setPosledniPrihlaseni(Date posledniPrihlaseni) {
		this.posledniPrihlaseni = posledniPrihlaseni;
	}

	public Set<Tabor> getTabors() {
		return tabors;
	}

	public void setTabors(Set<Tabor> tabors) {
		this.tabors = tabors;
	}

	public Boolean getSuperAdmin() {
		return superAdmin;
	}

	public void setSuperAdmin(Boolean superAdmin) {
		this.superAdmin = superAdmin;
	}



}