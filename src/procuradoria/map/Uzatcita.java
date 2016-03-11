package procuradoria.map;
// Generated Mar 11, 2016 1:10:52 AM by Hibernate Tools 3.6.0


import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Uzatcita generated by hbm2java
 */
public class Uzatcita  implements java.io.Serializable {


     private UzatcitaId id;
     private Uzatfase uzatfase;
     private String uzatcitaSala;
     private String uzatcitaFecha;
     private BigDecimal uzatcitaFlag;
     private BigDecimal uzatfuncionarioId;

    public Uzatcita() {
        this.id = new UzatcitaId();
        this.uzatfase = new Uzatfase();
        this.uzatfuncionarioId = new BigDecimal(BigInteger.ONE);
    }

	
    public Uzatcita(UzatcitaId id, Uzatfase uzatfase) {
        this.id = id;
        this.uzatfase = uzatfase;
    }
    public Uzatcita(UzatcitaId id, Uzatfase uzatfase, String uzatcitaSala, String uzatcitaFecha, BigDecimal uzatcitaFlag, BigDecimal uzatfuncionarioId) {
       this.id = id;
       this.uzatfase = uzatfase;
       this.uzatcitaSala = uzatcitaSala;
       this.uzatcitaFecha = uzatcitaFecha;
       this.uzatcitaFlag = uzatcitaFlag;
       this.uzatfuncionarioId = uzatfuncionarioId;
    }
   
    public UzatcitaId getId() {
        return this.id;
    }
    
    public void setId(UzatcitaId id) {
        this.id = id;
    }
    public Uzatfase getUzatfase() {
        return this.uzatfase;
    }
    
    public void setUzatfase(Uzatfase uzatfase) {
        this.uzatfase = uzatfase;
    }
    public String getUzatcitaSala() {
        return this.uzatcitaSala;
    }
    
    public void setUzatcitaSala(String uzatcitaSala) {
        this.uzatcitaSala = uzatcitaSala;
    }
    public String getUzatcitaFecha() {
        return this.uzatcitaFecha;
    }
    
    public void setUzatcitaFecha(String uzatcitaFecha) {
        this.uzatcitaFecha = uzatcitaFecha;
    }
    public BigDecimal getUzatcitaFlag() {
        return this.uzatcitaFlag;
    }
    
    public void setUzatcitaFlag(BigDecimal uzatcitaFlag) {
        this.uzatcitaFlag = uzatcitaFlag;
    }
    public BigDecimal getUzatfuncionarioId() {
        return this.uzatfuncionarioId;
    }
    
    public void setUzatfuncionarioId(BigDecimal uzatfuncionarioId) {
        this.uzatfuncionarioId = uzatfuncionarioId;
    }




}


