package procuradoria.map;
// Generated Mar 28, 2016 5:02:18 PM by Hibernate Tools 3.6.0


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * Uzatactor generated by hbm2java
 */
public class Uzatactor  implements java.io.Serializable {


     private BigDecimal uzatactorId;
     private String uzatactorNombres;
     private String uzatactorApellidos;
     private String uzatactorCedula;
     private String uzatactorDireccion;
     private String uzatactorMovil;
     private String uzatactorEmail;
     private String uzatactorInstitutcion;
     private String uzatactorIdbanner;
     private Set uzatinvCas = new HashSet(0);

    public Uzatactor() {
        this.uzatactorId = new BigDecimal(BigInteger.ONE);
    }

	
    public Uzatactor(BigDecimal uzatactorId) {
        this.uzatactorId = uzatactorId;
    }
    public Uzatactor(BigDecimal uzatactorId, String uzatactorNombres, String uzatactorApellidos, String uzatactorCedula, String uzatactorDireccion, String uzatactorMovil, String uzatactorEmail, String uzatactorInstitutcion, String uzatactorIdbanner, Set uzatinvCas) {
       this.uzatactorId = uzatactorId;
       this.uzatactorNombres = uzatactorNombres;
       this.uzatactorApellidos = uzatactorApellidos;
       this.uzatactorCedula = uzatactorCedula;
       this.uzatactorDireccion = uzatactorDireccion;
       this.uzatactorMovil = uzatactorMovil;
       this.uzatactorEmail = uzatactorEmail;
       this.uzatactorInstitutcion = uzatactorInstitutcion;
       this.uzatactorIdbanner = uzatactorIdbanner;
       this.uzatinvCas = uzatinvCas;
    }
   
    public BigDecimal getUzatactorId() {
        return this.uzatactorId;
    }
    
    public void setUzatactorId(BigDecimal uzatactorId) {
        this.uzatactorId = uzatactorId;
    }
    public String getUzatactorNombres() {
        return this.uzatactorNombres;
    }
    
    public void setUzatactorNombres(String uzatactorNombres) {
        this.uzatactorNombres = uzatactorNombres;
    }
    public String getUzatactorApellidos() {
        return this.uzatactorApellidos;
    }
    
    public void setUzatactorApellidos(String uzatactorApellidos) {
        this.uzatactorApellidos = uzatactorApellidos;
    }
    public String getUzatactorCedula() {
        return this.uzatactorCedula;
    }
    
    public void setUzatactorCedula(String uzatactorCedula) {
        this.uzatactorCedula = uzatactorCedula;
    }
    public String getUzatactorDireccion() {
        return this.uzatactorDireccion;
    }
    
    public void setUzatactorDireccion(String uzatactorDireccion) {
        this.uzatactorDireccion = uzatactorDireccion;
    }
    public String getUzatactorMovil() {
        return this.uzatactorMovil;
    }
    
    public void setUzatactorMovil(String uzatactorMovil) {
        this.uzatactorMovil = uzatactorMovil;
    }
    public String getUzatactorEmail() {
        return this.uzatactorEmail;
    }
    
    public void setUzatactorEmail(String uzatactorEmail) {
        this.uzatactorEmail = uzatactorEmail;
    }
    public String getUzatactorInstitutcion() {
        return this.uzatactorInstitutcion;
    }
    
    public void setUzatactorInstitutcion(String uzatactorInstitutcion) {
        this.uzatactorInstitutcion = uzatactorInstitutcion;
    }
    public String getUzatactorIdbanner() {
        return this.uzatactorIdbanner;
    }
    
    public void setUzatactorIdbanner(String uzatactorIdbanner) {
        this.uzatactorIdbanner = uzatactorIdbanner;
    }
    public Set getUzatinvCas() {
        return this.uzatinvCas;
    }
    
    public void setUzatinvCas(Set uzatinvCas) {
        this.uzatinvCas = uzatinvCas;
    }




}


