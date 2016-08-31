package cz.greca.tabor.skladGre.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="potravina", schema="tabor")
public class Potravina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="POTRAVINA_ID_GENERATOR", sequenceName="TABOR.HIBERNATE_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="POTRAVINA_ID_GENERATOR")
	private Long id;

	private String jmeno;

	public Potravina() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJmeno() {
		return this.jmeno;
	}

	public void setJmeno(String jmeno) {
		this.jmeno = jmeno;
	}

}