package procuradoria.map;
// Generated Feb 3, 2016 11:47:39 AM by Hibernate Tools 3.6.0


import java.sql.Blob;
import java.util.Date;

/**
 * Uzatdocs generated by hbm2java
 */
public class Uzatdocs  implements java.io.Serializable {


     private UzatdocsId id;
     private Uzatfase uzatfase;
     private String uzatdocsCasilla;
     private Date uzatdocsFecha;
     private String uzatdocsCompromiso;
     private Blob uzatdocsArchivo;

    public Uzatdocs() {
    }

	
    public Uzatdocs(UzatdocsId id, Uzatfase uzatfase) {
        this.id = id;
        this.uzatfase = uzatfase;
    }
    public Uzatdocs(UzatdocsId id, Uzatfase uzatfase, String uzatdocsCasilla, Date uzatdocsFecha, String uzatdocsCompromiso, Blob uzatdocsArchivo) {
       this.id = id;
       this.uzatfase = uzatfase;
       this.uzatdocsCasilla = uzatdocsCasilla;
       this.uzatdocsFecha = uzatdocsFecha;
       this.uzatdocsCompromiso = uzatdocsCompromiso;
       this.uzatdocsArchivo = uzatdocsArchivo;
    }
   
    public UzatdocsId getId() {
        return this.id;
    }
    
    public void setId(UzatdocsId id) {
        this.id = id;
    }
    public Uzatfase getUzatfase() {
        return this.uzatfase;
    }
    
    public void setUzatfase(Uzatfase uzatfase) {
        this.uzatfase = uzatfase;
    }
    public String getUzatdocsCasilla() {
        return this.uzatdocsCasilla;
    }
    
    public void setUzatdocsCasilla(String uzatdocsCasilla) {
        this.uzatdocsCasilla = uzatdocsCasilla;
    }
    public Date getUzatdocsFecha() {
        return this.uzatdocsFecha;
    }
    
    public void setUzatdocsFecha(Date uzatdocsFecha) {
        this.uzatdocsFecha = uzatdocsFecha;
    }
    public String getUzatdocsCompromiso() {
        return this.uzatdocsCompromiso;
    }
    
    public void setUzatdocsCompromiso(String uzatdocsCompromiso) {
        this.uzatdocsCompromiso = uzatdocsCompromiso;
    }
    public Blob getUzatdocsArchivo() {
        return this.uzatdocsArchivo;
    }
    
    public void setUzatdocsArchivo(Blob uzatdocsArchivo) {
        this.uzatdocsArchivo = uzatdocsArchivo;
    }




}


