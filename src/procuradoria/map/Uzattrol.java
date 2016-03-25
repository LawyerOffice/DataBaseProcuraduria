package procuradoria.map;
// Generated Mar 25, 2016 3:25:02 PM by Hibernate Tools 3.6.0


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * Uzattrol generated by hbm2java
 */
public class Uzattrol  implements java.io.Serializable {


     private BigDecimal uzattiporolId;
     private String uzattiporolDescripcion;
     private Set uzatrols = new HashSet(0);

    public Uzattrol() {
        this.uzattiporolId = new BigDecimal(BigInteger.ONE);
    }

	
    public Uzattrol(BigDecimal uzattiporolId) {
        this.uzattiporolId = uzattiporolId;
    }
    public Uzattrol(BigDecimal uzattiporolId, String uzattiporolDescripcion, Set uzatrols) {
       this.uzattiporolId = uzattiporolId;
       this.uzattiporolDescripcion = uzattiporolDescripcion;
       this.uzatrols = uzatrols;
    }
   
    public BigDecimal getUzattiporolId() {
        return this.uzattiporolId;
    }
    
    public void setUzattiporolId(BigDecimal uzattiporolId) {
        this.uzattiporolId = uzattiporolId;
    }
    public String getUzattiporolDescripcion() {
        return this.uzattiporolDescripcion;
    }
    
    public void setUzattiporolDescripcion(String uzattiporolDescripcion) {
        this.uzattiporolDescripcion = uzattiporolDescripcion;
    }
    public Set getUzatrols() {
        return this.uzatrols;
    }
    
    public void setUzatrols(Set uzatrols) {
        this.uzatrols = uzatrols;
    }




}


