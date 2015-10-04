package cz.greca.tabor.skladGre.obj;

public class FormObject {
	
	private long id;
	
	private String nick;
	
	private String password;
	
	private String role;
	
	private String prvniDen;
	
	private String posledniDen;
	
	private Integer pocetTaborovychDnu;
	
	private Integer norma;
	
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

	public String getPosledniDen() {
		return posledniDen;
	}

	public void setPosledniDen(String posledniDen) {
		this.posledniDen = posledniDen;
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
	
	
	
	
}
