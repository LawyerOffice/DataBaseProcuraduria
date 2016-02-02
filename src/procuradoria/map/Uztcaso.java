package procuradoria.map;
// Generated Feb 2, 2016 9:54:14 AM by Hibernate Tools 3.6.0


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * Uztcaso generated by hbm2java
 */
public class Uztcaso  implements java.io.Serializable {


     private BigDecimal uztcasoId;
     private Uztjudi uztjudi;
     private BigDecimal uztcasoFlag;
     private String uztcasoNumcausa;
     private String uztcasoMotivo;
     private String uztcasoDetalle;
     private String uztcasoTipo;
     private String uztcasoFechaIn;
     private String uztcasoFechaOut;
     private String uztcasoResolucion;
     private Set uztfases = new HashSet(0);
     private Set uztasignars = new HashSet(0);
     private Set uztinvolCas = new HashSet(0);

    public Uztcaso() {
        this.uztcasoFlag = new BigDecimal(BigInteger.ONE);
        this.uztcasoId = new BigDecimal(BigInteger.ONE);
    }

	
    public Uztcaso(BigDecimal uztcasoId, Uztjudi uztjudi) {
        this.uztcasoId = uztcasoId;
        this.uztjudi = uztjudi;
    }
    public Uztcaso(BigDecimal uztcasoId, Uztjudi uztjudi, BigDecimal uztcasoFlag, String uztcasoNumcausa, String uztcasoMotivo, String uztcasoDetalle, String uztcasoTipo, String uztcasoFechaIn, String uztcasoFechaOut, String uztcasoResolucion, Set uztfases, Set uztasignars, Set uztinvolCas) {
       this.uztcasoId = uztcasoId;
       this.uztjudi = uztjudi;
       this.uztcasoFlag = uztcasoFlag;
       this.uztcasoNumcausa = uztcasoNumcausa;
       this.uztcasoMotivo = uztcasoMotivo;
       this.uztcasoDetalle = uztcasoDetalle;
       this.uztcasoTipo = uztcasoTipo;
       this.uztcasoFechaIn = uztcasoFechaIn;
       this.uztcasoFechaOut = uztcasoFechaOut;
       this.uztcasoResolucion = uztcasoResolucion;
       this.uztfases = uztfases;
       this.uztasignars = uztasignars;
       this.uztinvolCas = uztinvolCas;
    }
   
    public BigDecimal getUztcasoId() {
        return this.uztcasoId;
    }
    
    public void setUztcasoId(BigDecimal uztcasoId) {
        this.uztcasoId = uztcasoId;
    }
    public Uztjudi getUztjudi() {
        return this.uztjudi;
    }
    
    public void setUztjudi(Uztjudi uztjudi) {
        this.uztjudi = uztjudi;
    }
    public BigDecimal getUztcasoFlag() {
        return this.uztcasoFlag;
    }
    
    public void setUztcasoFlag(BigDecimal uztcasoFlag) {
        this.uztcasoFlag = uztcasoFlag;
    }
    public String getUztcasoNumcausa() {
        return this.uztcasoNumcausa;
    }
    
    public void setUztcasoNumcausa(String uztcasoNumcausa) {
        this.uztcasoNumcausa = uztcasoNumcausa;
    }
    public String getUztcasoMotivo() {
        return this.uztcasoMotivo;
    }
    
    public void setUztcasoMotivo(String uztcasoMotivo) {
        this.uztcasoMotivo = uztcasoMotivo;
    }
    public String getUztcasoDetalle() {
        return this.uztcasoDetalle;
    }
    
    public void setUztcasoDetalle(String uztcasoDetalle) {
        this.uztcasoDetalle = uztcasoDetalle;
    }
    public String getUztcasoTipo() {
        return this.uztcasoTipo;
    }
    
    public void setUztcasoTipo(String uztcasoTipo) {
        this.uztcasoTipo = uztcasoTipo;
    }
    public String getUztcasoFechaIn() {
        return this.uztcasoFechaIn;
    }
    
    public void setUztcasoFechaIn(String uztcasoFechaIn) {
        this.uztcasoFechaIn = uztcasoFechaIn;
    }
    public String getUztcasoFechaOut() {
        return this.uztcasoFechaOut;
    }
    
    public void setUztcasoFechaOut(String uztcasoFechaOut) {
        this.uztcasoFechaOut = uztcasoFechaOut;
    }
    public String getUztcasoResolucion() {
        return this.uztcasoResolucion;
    }
    
    public void setUztcasoResolucion(String uztcasoResolucion) {
        this.uztcasoResolucion = uztcasoResolucion;
    }
    public Set getUztfases() {
        return this.uztfases;
    }
    
    public void setUztfases(Set uztfases) {
        this.uztfases = uztfases;
    }
    public Set getUztasignars() {
        return this.uztasignars;
    }
    
    public void setUztasignars(Set uztasignars) {
        this.uztasignars = uztasignars;
    }
    public Set getUztinvolCas() {
        return this.uztinvolCas;
    }
    
    public void setUztinvolCas(Set uztinvolCas) {
        this.uztinvolCas = uztinvolCas;
    }




}


