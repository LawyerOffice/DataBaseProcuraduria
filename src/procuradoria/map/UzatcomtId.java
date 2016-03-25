package procuradoria.map;
// Generated Mar 25, 2016 3:25:02 PM by Hibernate Tools 3.6.0


import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * UzatcomtId generated by hbm2java
 */
public class UzatcomtId  implements java.io.Serializable {


     private BigDecimal uzatcasoId;
     private BigDecimal uzatfaseId;
     private BigDecimal uzatcomtId;

    public UzatcomtId() {
        this.uzatcasoId = new BigDecimal(BigInteger.ONE);
        this.uzatcomtId = new BigDecimal(BigInteger.ONE);
        this.uzatfaseId = new BigDecimal(BigInteger.ONE);
    }

    public UzatcomtId(BigDecimal uzatcasoId, BigDecimal uzatfaseId, BigDecimal uzatcomtId) {
       this.uzatcasoId = uzatcasoId;
       this.uzatfaseId = uzatfaseId;
       this.uzatcomtId = uzatcomtId;
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
    public BigDecimal getUzatcomtId() {
        return this.uzatcomtId;
    }
    
    public void setUzatcomtId(BigDecimal uzatcomtId) {
        this.uzatcomtId = uzatcomtId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UzatcomtId) ) return false;
		 UzatcomtId castOther = ( UzatcomtId ) other; 
         
		 return ( (this.getUzatcasoId()==castOther.getUzatcasoId()) || ( this.getUzatcasoId()!=null && castOther.getUzatcasoId()!=null && this.getUzatcasoId().equals(castOther.getUzatcasoId()) ) )
 && ( (this.getUzatfaseId()==castOther.getUzatfaseId()) || ( this.getUzatfaseId()!=null && castOther.getUzatfaseId()!=null && this.getUzatfaseId().equals(castOther.getUzatfaseId()) ) )
 && ( (this.getUzatcomtId()==castOther.getUzatcomtId()) || ( this.getUzatcomtId()!=null && castOther.getUzatcomtId()!=null && this.getUzatcomtId().equals(castOther.getUzatcomtId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getUzatcasoId() == null ? 0 : this.getUzatcasoId().hashCode() );
         result = 37 * result + ( getUzatfaseId() == null ? 0 : this.getUzatfaseId().hashCode() );
         result = 37 * result + ( getUzatcomtId() == null ? 0 : this.getUzatcomtId().hashCode() );
         return result;
   }   


}


