package procuradoria.map;
// Generated Feb 3, 2016 11:47:39 AM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * UzatinvFf generated by hbm2java
 */
public class UzatinvFf  implements java.io.Serializable {


     private UzatinvFfId id;
     private Uzatfunci uzatfunci;
     private Uzatfase uzatfase;
     private Date uzatinvolFfFIn;
     private Date uzatinvolFfFOut;

    public UzatinvFf() {
    }

	
    public UzatinvFf(UzatinvFfId id, Uzatfunci uzatfunci, Uzatfase uzatfase) {
        this.id = id;
        this.uzatfunci = uzatfunci;
        this.uzatfase = uzatfase;
    }
    public UzatinvFf(UzatinvFfId id, Uzatfunci uzatfunci, Uzatfase uzatfase, Date uzatinvolFfFIn, Date uzatinvolFfFOut) {
       this.id = id;
       this.uzatfunci = uzatfunci;
       this.uzatfase = uzatfase;
       this.uzatinvolFfFIn = uzatinvolFfFIn;
       this.uzatinvolFfFOut = uzatinvolFfFOut;
    }
   
    public UzatinvFfId getId() {
        return this.id;
    }
    
    public void setId(UzatinvFfId id) {
        this.id = id;
    }
    public Uzatfunci getUzatfunci() {
        return this.uzatfunci;
    }
    
    public void setUzatfunci(Uzatfunci uzatfunci) {
        this.uzatfunci = uzatfunci;
    }
    public Uzatfase getUzatfase() {
        return this.uzatfase;
    }
    
    public void setUzatfase(Uzatfase uzatfase) {
        this.uzatfase = uzatfase;
    }
    public Date getUzatinvolFfFIn() {
        return this.uzatinvolFfFIn;
    }
    
    public void setUzatinvolFfFIn(Date uzatinvolFfFIn) {
        this.uzatinvolFfFIn = uzatinvolFfFIn;
    }
    public Date getUzatinvolFfFOut() {
        return this.uzatinvolFfFOut;
    }
    
    public void setUzatinvolFfFOut(Date uzatinvolFfFOut) {
        this.uzatinvolFfFOut = uzatinvolFfFOut;
    }




}


