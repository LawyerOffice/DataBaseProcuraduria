package procuradoria.map;
// Generated Jan 7, 2016 1:07:49 PM by Hibernate Tools 3.6.0


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Uztfase generated by hbm2java
 */
public class Uztfase  implements java.io.Serializable {


     private UztfaseId id;
     private Uztcaso uztcaso;
     private BigDecimal uztfaseFlag;
     private BigDecimal uztfaseNumfase;
     private String uztfaseNombre;
     private String uztfaseFechaIn;
     private String uztfaseFechaOut;
     private Set uztdocses = new HashSet(0);
     private Set uztcitas = new HashSet(0);
     private Set uztcomts = new HashSet(0);
     private Set uztinvolFfs = new HashSet(0);

    public Uztfase() {
        this.id = new UztfaseId();
        this.uztcaso = new Uztcaso();
    }

	
    public Uztfase(UztfaseId id, Uztcaso uztcaso) {
        this.id = id;
        this.uztcaso = uztcaso;
    }
    public Uztfase(UztfaseId id, Uztcaso uztcaso, BigDecimal uztfaseFlag, BigDecimal uztfaseNumfase, String uztfaseNombre, String uztfaseFechaIn, String uztfaseFechaOut, Set uztdocses, Set uztcitas, Set uztcomts, Set uztinvolFfs) {
       this.id = id;
       this.uztcaso = uztcaso;
       this.uztfaseFlag = uztfaseFlag;
       this.uztfaseNumfase = uztfaseNumfase;
       this.uztfaseNombre = uztfaseNombre;
       this.uztfaseFechaIn = uztfaseFechaIn;
       this.uztfaseFechaOut = uztfaseFechaOut;
       this.uztdocses = uztdocses;
       this.uztcitas = uztcitas;
       this.uztcomts = uztcomts;
       this.uztinvolFfs = uztinvolFfs;
    }
   
    public UztfaseId getId() {
        return this.id;
    }
    
    public void setId(UztfaseId id) {
        this.id = id;
    }
    public Uztcaso getUztcaso() {
        return this.uztcaso;
    }
    
    public void setUztcaso(Uztcaso uztcaso) {
        this.uztcaso = uztcaso;
    }
    public BigDecimal getUztfaseFlag() {
        return this.uztfaseFlag;
    }
    
    public void setUztfaseFlag(BigDecimal uztfaseFlag) {
        this.uztfaseFlag = uztfaseFlag;
    }
    public BigDecimal getUztfaseNumfase() {
        return this.uztfaseNumfase;
    }
    
    public void setUztfaseNumfase(BigDecimal uztfaseNumfase) {
        this.uztfaseNumfase = uztfaseNumfase;
    }
    public String getUztfaseNombre() {
        return this.uztfaseNombre;
    }
    
    public void setUztfaseNombre(String uztfaseNombre) {
        this.uztfaseNombre = uztfaseNombre;
    }
    public String getUztfaseFechaIn() {
        return this.uztfaseFechaIn;
    }
    
    public void setUztfaseFechaIn(String uztfaseFechaIn) {
        this.uztfaseFechaIn = uztfaseFechaIn;
    }
    public String getUztfaseFechaOut() {
        return this.uztfaseFechaOut;
    }
    
    public void setUztfaseFechaOut(String uztfaseFechaOut) {
        this.uztfaseFechaOut = uztfaseFechaOut;
    }
    public Set getUztdocses() {
        return this.uztdocses;
    }
    
    public void setUztdocses(Set uztdocses) {
        this.uztdocses = uztdocses;
    }
    public Set getUztcitas() {
        return this.uztcitas;
    }
    
    public void setUztcitas(Set uztcitas) {
        this.uztcitas = uztcitas;
    }
    public Set getUztcomts() {
        return this.uztcomts;
    }
    
    public void setUztcomts(Set uztcomts) {
        this.uztcomts = uztcomts;
    }
    public Set getUztinvolFfs() {
        return this.uztinvolFfs;
    }
    
    public void setUztinvolFfs(Set uztinvolFfs) {
        this.uztinvolFfs = uztinvolFfs;
    }




}


