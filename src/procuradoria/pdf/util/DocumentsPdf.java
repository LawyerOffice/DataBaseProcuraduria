/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procuradoria.pdf.util;

import com.logger.L;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.serial.SerialBlob;
import org.apache.commons.io.IOUtils;
import procuradoria.crud.ProcuradoriaMethods;
import procuradoria.map.Uzatdocs;


/**
 *
 * @author Ivan
 */
public class DocumentsPdf {
    
    private final static L log = new L(DocumentsPdf.class);

    public static Boolean SaveDocument(Uzatdocs docs, InputStream pdfBytes) {
        Boolean exito = false;
        try {          
            byte[] bFile = IOUtils.toByteArray(pdfBytes);
            java.sql.Blob blob = null;
            blob = new SerialBlob(bFile);
            docs.setUzatdocsArchivo(blob);
            exito = ProcuradoriaMethods.InsertDocs(docs);
        } catch (IOException ex) {
            log.level.info(">> IO PDF: "+ex.getMessage());
        } catch (SQLException ex) {
            log.level.info(">> SQL PDF: "+ex.getMessage());
        }
         return exito;
    }

    public static Boolean CovertPdfToByteArray(Uzatdocs docs, String Url) {

        FileInputStream in = null;
        File file = new File(Url);
        byte[] bFile = new byte[(int) file.length()];
        FileInputStream fileInputStream;
        Boolean exito = false;

        try {
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
            java.sql.Blob blob = null;
            blob = new SerialBlob(bFile);
            docs.setUzatdocsArchivo(blob);
            exito = ProcuradoriaMethods.InsertDocs(docs);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DocumentsPdf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DocumentsPdf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DocumentsPdf.class.getName()).log(Level.SEVERE, null, ex);
        }

        return exito;
    }

    public static void byteArrayToFile(Uzatdocs doc) {
        try {
            Blob blob = doc.getUzatdocsArchivo();

            int blobLength = (int) blob.length();
            byte[] bArray = blob.getBytes(1, blobLength);
            blob.free();
            OutputStream out = new FileOutputStream("out.pdf");
            out.write(bArray);
            out.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
