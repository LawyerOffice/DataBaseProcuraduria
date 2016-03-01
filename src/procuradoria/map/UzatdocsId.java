package procuradoria.map;
// Generated Mar 1, 2016 11:18:31 AM by Hibernate Tools 3.6.0


import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * UzatdocsId generated by hbm2java
 */
public class UzatdocsId  implements java.io.Serializable {


     private BigDecimal uzatcasoId;
     private BigDecimal uzatfaseId;
     private BigDecimal uzatdocsId;

    public UzatdocsId() {
        this.uzatcasoId = new BigDecimal(BigInteger.ONE);
        this.uzatdocsId = new BigDecimal(BigInteger.ONE);
        this.uzatfaseId = new BigDecimal(BigInteger.ONE);
    }

    public UzatdocsId(BigDecimal uzatcasoId, BigDecimal uzatfaseId, BigDecimal uzatdocsId) {
       this.uzatcasoId = uzatcasoId;
       this.uzatfaseId = uzatfaseId;
       this.uzatdocsId = uzatdocsId;
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
    public BigDecimal getUzatdocsId() {
        return this.uzatdocsId;
    }
    
    public void setUzatdocsId(BigDecimal uzatdocsId) {
        this.uzatdocsId = uzatdocsId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UzatdocsId) ) return false;
		 UzatdocsId castOther = ( UzatdocsId ) other; 
         
		 return ( (this.getUzatcasoId()==castOther.getUzatcasoId()) || ( this.getUzatcasoId()!=null && castOther.getUzatcasoId()!=null && this.getUzatcasoId().equals(castOther.getUzatcasoId()) ) )
 && ( (this.getUzatfaseId()==castOther.getUzatfaseId()) || ( this.getUzatfaseId()!=null && castOther.getUzatfaseId()!=null && this.getUzatfaseId().equals(castOther.getUzatfaseId()) ) )
 && ( (this.getUzatdocsId()==castOther.getUzatdocsId()) || ( this.getUzatdocsId()!=null && castOther.getUzatdocsId()!=null && this.getUzatdocsId().equals(castOther.getUzatdocsId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getUzatcasoId() == null ? 0 : this.getUzatcasoId().hashCode() );
         result = 37 * result + ( getUzatfaseId() == null ? 0 : this.getUzatfaseId().hashCode() );
         result = 37 * result + ( getUzatdocsId() == null ? 0 : this.getUzatdocsId().hashCode() );
         return result;
   }   


}


