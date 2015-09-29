package cz.greca.tabor.skladGre.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="user", schema="tabor")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USERS_ID_GENERATOR", sequenceName="tabor.HIBERNATE_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERS_ID_GENERATOR")
	private Integer id;

	private String nick;

	private String password;

	@Column(name="pocet_prihlaseni")
	private Integer pocetPrihlaseni;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="posledni_prihlaseni")
	private Date posledniPrihlaseni;

	private String role;

	public User() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}