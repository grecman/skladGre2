package cz.greca.tabor.skladGre.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Potravina {
	
	@Id
	@GeneratedValue
    private long id; 
    
    @Column(nullable=false, length=64) 
    private String jmeno; 
    
    //bi-directional many-to-one association to Sklad 
    @OneToMany(mappedBy="potravFK") 
    private Set<Sklad> sklad_set; 

    public long getId() { 
            return id; 
    } 

    public void setId(long id) { 
            this.id = id; 
    } 
    
    public String getJmeno() { 
            return jmeno; 
    } 

    public void setJmeno(String jmeno) { 
            this.jmeno = jmeno; 
    } 

    public Set<Sklad> getSklad_set() { 
            return sklad_set; 
    } 

    public void setSklad_set(Set<Sklad> sklad_set) { 
            this.sklad_set = sklad_set; 
    } 


}
