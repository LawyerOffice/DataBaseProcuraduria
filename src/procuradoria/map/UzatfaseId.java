package procuradoria.map;
// Generated Feb 5, 2016 12:46:40 PM by Hibernate Tools 3.6.0


import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * UzatfaseId generated by hbm2java
 */
public class UzatfaseId  implements java.io.Serializable {


     private BigDecimal uzatcasoId;
     private BigDecimal uzatfaseId;

    public UzatfaseId() {
        this.uzatcasoId = new BigDecimal(BigInteger.ONE);
        this.uzatfaseId = new BigDecimal(BigInteger.ONE);
    }

    public UzatfaseId(BigDecimal uzatcasoId, BigDecimal uzatfaseId) {
       this.uzatcasoId = uzatcasoId;
       this.uzatfaseId = uzatfaseId;
    }
   
    public BigDecimal getUzatcasoId() {
        return this.uzatcasoId;
    }
    
    public void setUzatcasoId(BigDecimal uzatcasoId) {
        this.uzatcasoId = uzatcasoId;
    }
    public BigDecimal getUzatfaseId() {
        return this.uzatfaseId;
    }
    
    public void setUzatfaseId(BigDecimal uzatfaseId) {
        this.uzatfaseId = uzatfaseId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UzatfaseId) ) return false;
		 UzatfaseId castOther = ( UzatfaseId ) other; 
         
		 return ( (this.getUzatcasoId()==castOther.getUzatcasoId()) || ( this.getUzatcasoId()!=null && castOther.getUzatcasoId()!=null && this.getUzatcasoId().equals(castOther.getUzatcasoId()) ) )
 && ( (this.getUzatfaseId()==castOther.getUzatfaseId()) || ( this.getUzatfaseId()!=null && castOther.getUzatfaseId()!=null && this.getUzatfaseId().equals(castOther.getUzatfaseId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getUzatcasoId() == null ? 0 : this.getUzatcasoId().hashCode() );
         result = 37 * result + ( getUzatfaseId() == null ? 0 : this.getUzatfaseId().hashCode() );
         return result;
   }   


}

