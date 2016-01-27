/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procuradoria.pdf.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.serial.SerialBlob;
import procuradoria.crud.ProcuradoriaMethods;
import procuradoria.map.Uztdocs;

/**
 *
 * @author Ivan
 */
public class DocumentsPdf {

    public void CovertPdfToByteArray(Uztdocs docs, String Url, String filename) {
          
        FileInputStream in = null;   
        File file = new File(Url);     
        byte[] bFile = new byte[(int) file.length()];
        FileInputStream fileInputStream;       
        
        
        try {
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
            java.sql.Blob blob=null;
            blob=new SerialBlob(bFile);   
            docs.setUztdocsArchivo(blob);
            Boolean exito = ProcuradoriaMethods.InsertDocs(docs);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DocumentsPdf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DocumentsPdf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DocumentsPdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
