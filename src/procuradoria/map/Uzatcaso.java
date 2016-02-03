package procuradoria.map;
// Generated Feb 3, 2016 11:47:39 AM by Hibernate Tools 3.6.0


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Uzatcaso generated by hbm2java
 */
public class Uzatcaso  implements java.io.Serializable {


     private BigDecimal uzatcasoId;
     private Uzatjudi uzatjudi;
     private BigDecimal uzatcasoFlag;
     private String uzatcasoNumcausa;
     private String uzatcasoMotivo;
     private String uzatcasoDetalle;
     private String uzatcasoTipo;
     private Date uzatcasoFechaIn;
     private Date uzatcasoFechaOut;
     private String uzatcasoResolucion;
     private Set uzatasigns = new HashSet(0);
     private Set uzatinvCas = new HashSet(0);
     private Set uzatfases = new HashSet(0);

    public Uzatcaso() {
    }

	
    public Uzatcaso(BigDecimal uzatcasoId, Uzatjudi uzatjudi) {
        this.uzatcasoId = uzatcasoId;
        this.uzatjudi = uzatjudi;
    }
    public Uzatcaso(BigDecimal uzatcasoId, Uzatjudi uzatjudi, BigDecimal uzatcasoFlag, String uzatcasoNumcausa, String uzatcasoMotivo, String uzatcasoDetalle, String uzatcasoTipo, Date uzatcasoFechaIn, Date uzatcasoFechaOut, String uzatcasoResolucion, Set uzatasigns, Set uzatinvCas, Set uzatfases) {
       this.uzatcasoId = uzatcasoId;
       this.uzatjudi = uzatjudi;
       this.uzatcasoFlag = uzatcasoFlag;
       this.uzatcasoNumcausa = uzatcasoNumcausa;
       this.uzatcasoMotivo = uzatcasoMotivo;
       this.uzatcasoDetalle = uzatcasoDetalle;
       this.uzatcasoTipo = uzatcasoTipo;
       this.uzatcasoFechaIn = uzatcasoFechaIn;
       this.uzatcasoFechaOut = uzatcasoFechaOut;
       this.uzatcasoResolucion = uzatcasoResolucion;
       this.uzatasigns = uzatasigns;
       this.uzatinvCas = uzatinvCas;
       this.uzatfases = uzatfases;
    }
   
    public BigDecimal getUzatcasoId() {
        return this.uzatcasoId;
    }
    
    public void setUzatcasoId(BigDecimal uzatcasoId) {
        this.uzatcasoId = uzatcasoId;
    }
    public Uzatjudi getUzatjudi() {
        return this.uzatjudi;
    }
    
    public void setUzatjudi(Uzatjudi uzatjudi) {
        this.uzatjudi = uzatjudi;
    }
    public BigDecimal getUzatcasoFlag() {
        return this.uzatcasoFlag;
    }
    
    public void setUzatcasoFlag(BigDecimal uzatcasoFlag) {
        this.uzatcasoFlag = uzatcasoFlag;
    }
    public String getUzatcasoNumcausa() {
        return this.uzatcasoNumcausa;
    }
    
    public void setUzatcasoNumcausa(String uzatcasoNumcausa) {
        this.uzatcasoNumcausa = uzatcasoNumcausa;
    }
    public String getUzatcasoMotivo() {
        return this.uzatcasoMotivo;
    }
    
    public void setUzatcasoMotivo(String uzatcasoMotivo) {
        this.uzatcasoMotivo = uzatcasoMotivo;
    }
    public String getUzatcasoDetalle() {
        return this.uzatcasoDetalle;
    }
    
    public void setUzatcasoDetalle(String uzatcasoDetalle) {
        this.uzatcasoDetalle = uzatcasoDetalle;
    }
    public String getUzatcasoTipo() {
        return this.uzatcasoTipo;
    }
    
    public void setUzatcasoTipo(String uzatcasoTipo) {
        this.uzatcasoTipo = uzatcasoTipo;
    }
    public Date getUzatcasoFechaIn() {
        return this.uzatcasoFechaIn;
    }
    
    public void setUzatcasoFechaIn(Date uzatcasoFechaIn) {
        this.uzatcasoFechaIn = uzatcasoFechaIn;
    }
    public Date getUzatcasoFechaOut() {
        return this.uzatcasoFechaOut;
    }
    
    public void setUzatcasoFechaOut(Date uzatcasoFechaOut) {
        this.uzatcasoFechaOut = uzatcasoFechaOut;
    }
    public String getUzatcasoResolucion() {
        return this.uzatcasoResolucion;
    }
    
    public void setUzatcasoResolucion(String uzatcasoResolucion) {
        this.uzatcasoResolucion = uzatcasoResolucion;
    }
    public Set getUzatasigns() {
        return this.uzatasigns;
    }
    
    public void setUzatasigns(Set uzatasigns) {
        this.uzatasigns = uzatasigns;
    }
    public Set getUzatinvCas() {
        return this.uzatinvCas;
    }
    
    public void setUzatinvCas(Set uzatinvCas) {
        this.uzatinvCas = uzatinvCas;
    }
    public Set getUzatfases() {
        return this.uzatfases;
    }
    
    public void setUzatfases(Set uzatfases) {
        this.uzatfases = uzatfases;
    }




}


