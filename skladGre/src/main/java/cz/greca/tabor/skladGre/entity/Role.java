package cz.greca.tabor.skladGre.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="role", schema="tabor")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ROLE_ID_GENERATOR", sequenceName="TABOR.HIBERNATE_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROLE_ID_GENERATOR")
	private Long id;

	//bi-directional many-to-one association to RoleList
	@ManyToOne
	@JoinColumn(name="id_role")
	private RoleList roleList;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="id_tabor")
	private Tabor tabor;

	public Role() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RoleList getRoleList() {
		return this.roleList;
	}

	public void setRoleList(RoleList roleList) {
		this.roleList = roleList;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Tabor getTabor() {
		return tabor;
	}

	public void setTabor(Tabor tabor) {
		this.tabor = tabor;
	}
	
	

	
	
}