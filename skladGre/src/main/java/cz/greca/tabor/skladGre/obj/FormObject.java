package cz.greca.tabor.skladGre.obj;

import java.util.Date;

public class FormObject {
	
	private long id;
	
	private String nick;
	
	private String password;
	
	private String role;
	
	private String prvniDen;
	
	private Integer pocetTaborovychDnu;
	
	private Integer norma;
	
	private String jmeno;
	
	private Date den;
	
	private String mernaJednotka;
	
	private String cena;
	
	private String mnozstvi;
	
	private Integer uctenka;
		
	private Boolean admin;
	
	private Integer rok;
	
	private String misto;
	
	private String beh;
	
	
		
	public Integer getRok() {
		return rok;
	}

	public void setRok(Integer rok) {
		this.rok = rok;
	}

	public String getMisto() {
		return misto;
	}

	public void setMisto(String misto) {
		this.misto = misto;
	}

	public String getBeh() {
		return beh;
	}

	public void setBeh(String beh) {
		this.beh = beh;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPrvniDen() {
		return prvniDen;
	}

	public void setPrvniDen(String prvniDen) {
		this.prvniDen = prvniDen;
	}

	public Integer getPocetTaborovychDnu() {
		return pocetTaborovychDnu;
	}

	public void setPocetTaborovychDnu(Integer pocetTaborovychDnu) {
		this.pocetTaborovychDnu = pocetTaborovychDnu;
	}

	public Integer getNorma() {
		return norma;
	}

	public void setNorma(Integer norma) {
		this.norma = norma;
	}

	public String getJmeno() {
		return jmeno;
	}

	public void setJmeno(String jmeno) {
		this.jmeno = jmeno;
	}

	public Date getDen() {
		return den;
	}

	public void setDen(Date den) {
		this.den = den;
	}


	public String getMernaJednotka() {
		return mernaJednotka;
	}

	public void setMernaJednotka(String mernaJednotka) {
		this.mernaJednotka = mernaJednotka;
	}

	public String getCena() {
		return cena;
	}

	public void setCena(String cena) {
		this.cena = cena;
	}

	public String getMnozstvi() {
		return mnozstvi;
	}

	public void setMnozstvi(String mnozstvi) {
		this.mnozstvi = mnozstvi;
	}

	public Integer getUctenka() {
		return uctenka;
	}

	public void setUctenka(Integer uctenka) {
		this.uctenka = uctenka;
	}

}
