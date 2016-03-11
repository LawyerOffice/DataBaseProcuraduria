package procuradoria.map;
// Generated Mar 11, 2016 1:10:52 AM by Hibernate Tools 3.6.0


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * Uzatfunci generated by hbm2java
 */
public class Uzatfunci  implements java.io.Serializable {


     private BigDecimal uzatfuncionarioId;
     private String uzatfuncionarioIdbanner;
     private String uzatfuncionarioNombres;
     private String uzatfuncionarioApellidos;
     private String uzatfuncionarioCedula;
     private String uzatfuncionarioEmail;
     private String uzatfuncionarioMovil;
     private BigDecimal uzatfuncionarioFlag;
     private Set uzatasigns = new HashSet(0);
     private Set uzatinvFfs = new HashSet(0);
     private Set uzatrols = new HashSet(0);

    public Uzatfunci() {
        this.uzatfuncionarioId = new BigDecimal(BigInteger.ONE);
    }

	
    public Uzatfunci(BigDecimal uzatfuncionarioId) {
        this.uzatfuncionarioId = uzatfuncionarioId;
    }
    public Uzatfunci(BigDecimal uzatfuncionarioId, String uzatfuncionarioIdbanner, String uzatfuncionarioNombres, String uzatfuncionarioApellidos, String uzatfuncionarioCedula, String uzatfuncionarioEmail, String uzatfuncionarioMovil, BigDecimal uzatfuncionarioFlag, Set uzatasigns, Set uzatinvFfs, Set uzatrols) {
       this.uzatfuncionarioId = uzatfuncionarioId;
       this.uzatfuncionarioIdbanner = uzatfuncionarioIdbanner;
       this.uzatfuncionarioNombres = uzatfuncionarioNombres;
       this.uzatfuncionarioApellidos = uzatfuncionarioApellidos;
       this.uzatfuncionarioCedula = uzatfuncionarioCedula;
       this.uzatfuncionarioEmail = uzatfuncionarioEmail;
       this.uzatfuncionarioMovil = uzatfuncionarioMovil;
       this.uzatfuncionarioFlag = uzatfuncionarioFlag;
       this.uzatasigns = uzatasigns;
       this.uzatinvFfs = uzatinvFfs;
       this.uzatrols = uzatrols;
    }
   
    public BigDecimal getUzatfuncionarioId() {
        return this.uzatfuncionarioId;
    }
    
    public void setUzatfuncionarioId(BigDecimal uzatfuncionarioId) {
        this.uzatfuncionarioId = uzatfuncionarioId;
    }
    public String getUzatfuncionarioIdbanner() {
        return this.uzatfuncionarioIdbanner;
    }
    
    public void setUzatfuncionarioIdbanner(String uzatfuncionarioIdbanner) {
        this.uzatfuncionarioIdbanner = uzatfuncionarioIdbanner;
    }
    public String getUzatfuncionarioNombres() {
        return this.uzatfuncionarioNombres;
    }
    
    public void setUzatfuncionarioNombres(String uzatfuncionarioNombres) {
        this.uzatfuncionarioNombres = uzatfuncionarioNombres;
    }
    public String getUzatfuncionarioApellidos() {
        return this.uzatfuncionarioApellidos;
    }
    
    public void setUzatfuncionarioApellidos(String uzatfuncionarioApellidos) {
        this.uzatfuncionarioApellidos = uzatfuncionarioApellidos;
    }
    public String getUzatfuncionarioCedula() {
        return this.uzatfuncionarioCedula;
    }
    
    public void setUzatfuncionarioCedula(String uzatfuncionarioCedula) {
        this.uzatfuncionarioCedula = uzatfuncionarioCedula;
    }
    public String getUzatfuncionarioEmail() {
        return this.uzatfuncionarioEmail;
    }
    
    public void setUzatfuncionarioEmail(String uzatfuncionarioEmail) {
        this.uzatfuncionarioEmail = uzatfuncionarioEmail;
    }
    public String getUzatfuncionarioMovil() {
        return this.uzatfuncionarioMovil;
    }
    
    public void setUzatfuncionarioMovil(String uzatfuncionarioMovil) {
        this.uzatfuncionarioMovil = uzatfuncionarioMovil;
    }
    public BigDecimal getUzatfuncionarioFlag() {
        return this.uzatfuncionarioFlag;
    }
    
    public void setUzatfuncionarioFlag(BigDecimal uzatfuncionarioFlag) {
        this.uzatfuncionarioFlag = uzatfuncionarioFlag;
    }
    public Set getUzatasigns() {
        return this.uzatasigns;
    }
    
    public void setUzatasigns(Set uzatasigns) {
        this.uzatasigns = uzatasigns;
    }
    public Set getUzatinvFfs() {
        return this.uzatinvFfs;
    }
    
    public void setUzatinvFfs(Set uzatinvFfs) {
        this.uzatinvFfs = uzatinvFfs;
    }
    public Set getUzatrols() {
        return this.uzatrols;
    }
    
    public void setUzatrols(Set uzatrols) {
        this.uzatrols = uzatrols;
    }




}


