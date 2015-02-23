package cz.greca.tabor.skladGre.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Sklad {
	@Id
	@GeneratedValue
    private long id; 
    
    private float cena; 
    
    private int uctenka; 
    
    @Temporal(TemporalType.TIMESTAMP) 
    @Column(nullable=false) 
    private Date datumPrijmu; 
    
    @Temporal(TemporalType.TIMESTAMP) 
    @Column(nullable=true) 
    private Date datumVydeje; 
    
    @ManyToOne 
    @JoinColumn(name="ID_POTRAVINA", nullable=false) 
    private Potravina potravFK; 
    
    @ManyToOne 
    @JoinColumn(name="ID_TABOROVY_DEN", nullable=false) 
    private TaborovyDen taborDenFK; 

    public long getId() { 
            return id; 
    } 

    public void setId(long id) { 
            this.id = id; 
    } 

    public float getCena() { 
            return cena; 
    } 

    public void setCena(float cena) { 
            this.cena = cena; 
    } 

    public int getUctenka() { 
            return uctenka; 
    } 

    public void setUctenka(int uctenka) { 
            this.uctenka = uctenka; 
    } 

    public Date getDatumPrijmu() { 
            return datumPrijmu; 
    } 

    public void setDatumPrijmu(Date datumPrijmu) { 
            this.datumPrijmu = datumPrijmu; 
    } 

    public Date getDatumVydeje() { 
            return datumVydeje; 
    } 

    public void setDatumVydeje(Date datumVydeje) { 
            this.datumVydeje = datumVydeje; 
    } 

    public Potravina getPotravFK() { 
            return potravFK; 
    } 

    public void setPotravFK(Potravina potravFK) { 
            this.potravFK = potravFK; 
    } 

    public TaborovyDen getTaborDenFK() { 
            return taborDenFK; 
    } 

    public void setTaborDenFK(TaborovyDen taborDenFK) { 
            this.taborDenFK = taborDenFK; 
    } 


}
