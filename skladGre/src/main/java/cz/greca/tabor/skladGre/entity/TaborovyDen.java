package cz.greca.tabor.skladGre.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class TaborovyDen {
	
	@Id
	@GeneratedValue
    private Integer id; 
    
    @Temporal(TemporalType.TIMESTAMP) 
    @Column(nullable=false) 
    private Date den; 

    private int norma; 
    
    //bi-directional many-to-one association to Sklad 
    @OneToMany(mappedBy="taborDenFK") 
    private Set<Sklad> sklad_set; 

    public Integer getId() { 
            return id; 
    } 

    public void setId(Integer id) { 
            this.id = id; 
    } 

    public Date getDen() { 
            return den; 
    } 

    public void setDen(Date den) { 
            this.den = den; 
    } 

    public int getNorma() { 
            return norma; 
    } 

    public void setNorma(int norma) { 
            this.norma = norma; 
    } 

    public Set<Sklad> getSklad_set() { 
            return sklad_set; 
    } 

    public void setSklad_set(Set<Sklad> sklad_set) { 
            this.sklad_set = sklad_set; 
    } 

	

}
