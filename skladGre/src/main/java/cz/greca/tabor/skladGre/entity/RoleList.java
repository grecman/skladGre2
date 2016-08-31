package cz.greca.tabor.skladGre.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="role_list", schema="tabor")
public class RoleList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ROLE_LIST_ID_GENERATOR", sequenceName="TABOR.HIBERNATE_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROLE_LIST_ID_GENERATOR")
	private Long id;

	private String role;
	
	private String popis;

	//bi-directional many-to-one association to Role
	@OneToMany(mappedBy="roleList")
	private Set<Role> roles;

	public RoleList() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	public String getPopis() {
		return popis;
	}

	public void setPopis(String popis) {
		this.popis = popis;
	}

	public Role addRole(Role role) {
		getRoles().add(role);
		role.setRoleList(this);

		return role;
	}

	public Role removeRole(Role role) {
		getRoles().remove(role);
		role.setRoleList(null);

		return role;
	}

}