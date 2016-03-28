package procuradoria.map;
// Generated Mar 28, 2016 5:02:18 PM by Hibernate Tools 3.6.0


import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * UzatjudiId generated by hbm2java
 */
public class UzatjudiId  implements java.io.Serializable {


     private BigDecimal uzatmateriaId;
     private BigDecimal uzatjudiId;

    public UzatjudiId() {
        this.uzatjudiId = new BigDecimal(BigInteger.ONE);
        this.uzatmateriaId = new BigDecimal(BigInteger.ONE);
    }

    public UzatjudiId(BigDecimal uzatmateriaId, BigDecimal uzatjudiId) {
       this.uzatmateriaId = uzatmateriaId;
       this.uzatjudiId = uzatjudiId;
    }
   
    public BigDecimal getUzatmateriaId() {
        return this.uzatmateriaId;
    }
    
    public void setUzatmateriaId(BigDecimal uzatmateriaId) {
        this.uzatmateriaId = uzatmateriaId;
    }
    public BigDecimal getUzatjudiId() {
        return this.uzatjudiId;
    }
    
    public void setUzatjudiId(BigDecimal uzatjudiId) {
        this.uzatjudiId = uzatjudiId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UzatjudiId) ) return false;
		 UzatjudiId castOther = ( UzatjudiId ) other; 
         
		 return ( (this.getUzatmateriaId()==castOther.getUzatmateriaId()) || ( this.getUzatmateriaId()!=null && castOther.getUzatmateriaId()!=null && this.getUzatmateriaId().equals(castOther.getUzatmateriaId()) ) )
 && ( (this.getUzatjudiId()==castOther.getUzatjudiId()) || ( this.getUzatjudiId()!=null && castOther.getUzatjudiId()!=null && this.getUzatjudiId().equals(castOther.getUzatjudiId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getUzatmateriaId() == null ? 0 : this.getUzatmateriaId().hashCode() );
         result = 37 * result + ( getUzatjudiId() == null ? 0 : this.getUzatjudiId().hashCode() );
         return result;
   }   


}


