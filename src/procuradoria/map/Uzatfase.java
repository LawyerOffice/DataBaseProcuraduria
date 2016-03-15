package procuradoria.map;
// Generated Mar 11, 2016 1:10:52 AM by Hibernate Tools 3.6.0


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * Uzatfase generated by hbm2java
 */
public class Uzatfase  implements java.io.Serializable {


     private UzatfaseId id;
     private Uzatcaso uzatcaso;
     private BigDecimal uzatfaseFlag;
     private BigDecimal uzatfaseNumfase;
     private String uzatfaseNombre;
     private String uzatfaseFechaIn;
     private String uzatfaseFechaOut;
     private Set uzatdocses = new HashSet(0);
     private Set uzatinvFfs = new HashSet(0);
     private Set uzatcomts = new HashSet(0);
     private Set uzatcitas = new HashSet(0);
     
     private Boolean StateFaseDisabled;

    public Uzatfase() {
        this.id = new UzatfaseId();
        this.uzatcaso = new Uzatcaso();
        this.uzatcaso = new Uzatcaso();
    }

	
    public Uzatfase(UzatfaseId id, Uzatcaso uzatcaso) {
        this.id = id;
        this.uzatcaso = uzatcaso;
    }
    public Uzatfase(UzatfaseId id, Uzatcaso uzatcaso, BigDecimal uzatfaseFlag, BigDecimal uzatfaseNumfase, String uzatfaseNombre, String uzatfaseFechaIn, String uzatfaseFechaOut, Set uzatdocses, Set uzatinvFfs, Set uzatcomts, Set uzatcitas) {
       this.id = id;
       this.uzatcaso = uzatcaso;
       this.uzatfaseFlag = uzatfaseFlag;
       this.uzatfaseNumfase = uzatfaseNumfase;
       this.uzatfaseNombre = uzatfaseNombre;
       this.uzatfaseFechaIn = uzatfaseFechaIn;
       this.uzatfaseFechaOut = uzatfaseFechaOut;
       this.uzatdocses = uzatdocses;
       this.uzatinvFfs = uzatinvFfs;
       this.uzatcomts = uzatcomts;
       this.uzatcitas = uzatcitas;
    }
   
    public UzatfaseId getId() {
        return this.id;
    }
    
    public void setId(UzatfaseId id) {
        this.id = id;
    }
    public Uzatcaso getUzatcaso() {
        return this.uzatcaso;
    }
    
    public void setUzatcaso(Uzatcaso uzatcaso) {
        this.uzatcaso = uzatcaso;
    }
    public BigDecimal getUzatfaseFlag() {
        return this.uzatfaseFlag;
    }
    
    public void setUzatfaseFlag(BigDecimal uzatfaseFlag) {
        this.uzatfaseFlag = uzatfaseFlag;
    }
    public BigDecimal getUzatfaseNumfase() {
        return this.uzatfaseNumfase;
    }
    
    public void setUzatfaseNumfase(BigDecimal uzatfaseNumfase) {
        this.uzatfaseNumfase = uzatfaseNumfase;
    }
    public String getUzatfaseNombre() {
        return this.uzatfaseNombre;
    }
    
    public void setUzatfaseNombre(String uzatfaseNombre) {
        this.uzatfaseNombre = uzatfaseNombre;
    }
    public String getUzatfaseFechaIn() {
        return this.uzatfaseFechaIn;
    }
    
    public void setUzatfaseFechaIn(String uzatfaseFechaIn) {
        this.uzatfaseFechaIn = uzatfaseFechaIn;
    }
    public String getUzatfaseFechaOut() {
        return this.uzatfaseFechaOut;
    }
    
    public void setUzatfaseFechaOut(String uzatfaseFechaOut) {
        this.uzatfaseFechaOut = uzatfaseFechaOut;
    }
    public Set getUzatdocses() {
        return this.uzatdocses;
    }
    
    public void setUzatdocses(Set uzatdocses) {
        this.uzatdocses = uzatdocses;
    }
    public Set getUzatinvFfs() {
        return this.uzatinvFfs;
    }
    
    public void setUzatinvFfs(Set uzatinvFfs) {
        this.uzatinvFfs = uzatinvFfs;
    }
    public Set getUzatcomts() {
        return this.uzatcomts;
    }
    
    public void setUzatcomts(Set uzatcomts) {
        this.uzatcomts = uzatcomts;
    }
    public Set getUzatcitas() {
        return this.uzatcitas;
    }
    
    public void setUzatcitas(Set uzatcitas) {
        this.uzatcitas = uzatcitas;
    }

    public Boolean getStateFaseDisabled() {
        return StateFaseDisabled;
    }

    public void setStateFaseDisabled(Boolean StateFaseDisabled) {
        this.StateFaseDisabled = StateFaseDisabled;
    }




}


