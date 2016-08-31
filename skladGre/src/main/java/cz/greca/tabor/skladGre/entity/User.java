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
	@SequenceGenerator(name="USER_ID_GENERATOR", sequenceName="TABOR.HIBERNATE_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_ID_GENERATOR")
	private Long id;

	private String nick;

	private String password;
	
	private Boolean admin;

	@Column(name="pocet_prihlaseni")
	private Integer pocetPrihlaseni;

	@Temporal(TemporalType.DATE)
	@Column(name="posledni_prihlaseni")
	private Date posledniPrihlaseni;

	//bi-directional many-to-one association to Role
	@OneToMany(mappedBy="user")
	private Set<Role> roles;

	public User() {
	}
	
	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
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
	
	
	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Role addRole(Role role) {
		getRoles().add(role);
		role.setUser(this);

		return role;
	}

	public Role removeRole(Role role) {
		getRoles().remove(role);
		role.setUser(null);

		return role;
	}

}