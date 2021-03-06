package procuradoria.map;
// Generated 07/04/2016 02:59:05 PM by Hibernate Tools 3.6.0

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Uzatcita generated by hbm2java
 */
public class Uzatcita implements java.io.Serializable {

    private UzatcitaId id;
    private Uzatfase uzatfase;
    private String uzatcitaSala;
    private String uzatcitaFecha;
    private BigDecimal uzatcitaFlag;
    private BigDecimal uzatfuncionarioId;
    private String uzatcitaDescripcion;

    public Uzatcita() {
        this.id = new UzatcitaId();
        this.uzatfase = new Uzatfase();
        this.uzatcitaFlag = new BigDecimal(BigInteger.ZERO);
        this.uzatfuncionarioId = new BigDecimal(BigInteger.ZERO);
    }

    public Uzatcita(UzatcitaId id, Uzatfase uzatfase) {
        this.id = id;
        this.uzatfase = uzatfase;
    }

    public Uzatcita(UzatcitaId id, Uzatfase uzatfase, String uzatcitaSala, String uzatcitaFecha, BigDecimal uzatcitaFlag, BigDecimal uzatfuncionarioId, String uzatcitaDescripcion) {
        this.id = id;
        this.uzatfase = uzatfase;
        this.uzatcitaSala = uzatcitaSala;
        this.uzatcitaFecha = uzatcitaFecha;
        this.uzatcitaFlag = uzatcitaFlag;
        this.uzatfuncionarioId = uzatfuncionarioId;
        this.uzatcitaDescripcion = uzatcitaDescripcion;
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

    public String getUzatcitaDescripcion() {
        return this.uzatcitaDescripcion;
    }

    public void setUzatcitaDescripcion(String uzatcitaDescripcion) {
        this.uzatcitaDescripcion = uzatcitaDescripcion;
    }

}
