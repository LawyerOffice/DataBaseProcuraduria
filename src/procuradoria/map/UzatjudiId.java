package procuradoria.map;
// Generated Feb 3, 2016 11:47:39 AM by Hibernate Tools 3.6.0


import java.math.BigDecimal;

/**
 * UzatjudiId generated by hbm2java
 */
public class UzatjudiId  implements java.io.Serializable {


     private BigDecimal uzatmateriaId;
     private BigDecimal uzatjudiId;

    public UzatjudiId() {
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


