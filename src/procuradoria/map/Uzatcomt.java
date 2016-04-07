package procuradoria.map;
// Generated 07/04/2016 02:59:05 PM by Hibernate Tools 3.6.0

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Uzatcomt generated by hbm2java
 */
public class Uzatcomt implements java.io.Serializable {

    private UzatcomtId id;
    private Uzatfase uzatfase;
    private String uzatcomtDescripcion;
    private String uzatcomtFecha;
    private BigDecimal uzatfuncionarioId;

    public Uzatcomt() {
        this.id = new UzatcomtId();
        this.uzatfase = new Uzatfase();
        this.uzatfuncionarioId = new BigDecimal(BigInteger.ZERO);
    }

    public Uzatcomt(UzatcomtId id, Uzatfase uzatfase) {
        this.id = id;
        this.uzatfase = uzatfase;
    }

    public Uzatcomt(UzatcomtId id, Uzatfase uzatfase, String uzatcomtDescripcion, String uzatcomtFecha, BigDecimal uzatfuncionarioId) {
        this.id = id;
        this.uzatfase = uzatfase;
        this.uzatcomtDescripcion = uzatcomtDescripcion;
        this.uzatcomtFecha = uzatcomtFecha;
        this.uzatfuncionarioId = uzatfuncionarioId;
    }

    public UzatcomtId getId() {
        return this.id;
    }

    public void setId(UzatcomtId id) {
        this.id = id;
    }

    public Uzatfase getUzatfase() {
        return this.uzatfase;
    }

    public void setUzatfase(Uzatfase uzatfase) {
        this.uzatfase = uzatfase;
    }

    public String getUzatcomtDescripcion() {
        return this.uzatcomtDescripcion;
    }

    public void setUzatcomtDescripcion(String uzatcomtDescripcion) {
        this.uzatcomtDescripcion = uzatcomtDescripcion;
    }

    public String getUzatcomtFecha() {
        return this.uzatcomtFecha;
    }

    public void setUzatcomtFecha(String uzatcomtFecha) {
        this.uzatcomtFecha = uzatcomtFecha;
    }

    public BigDecimal getUzatfuncionarioId() {
        return this.uzatfuncionarioId;
    }

    public void setUzatfuncionarioId(BigDecimal uzatfuncionarioId) {
        this.uzatfuncionarioId = uzatfuncionarioId;
    }

}
