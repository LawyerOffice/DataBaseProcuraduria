/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procuradoria.pdf.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.serial.SerialBlob;
import procuradoria.crud.ProcuradoriaMethods;
import procuradoria.map.Uzatdocs;

/**
 *
 * @author Ivan
 */
public class DocumentsPdf {

    public static Boolean CovertPdfToByteArray(Uzatdocs docs, String Url, String filename) {

        FileInputStream in = null;
        File file = new File(Url);
        byte[] bFile = new byte[(int) file.length()];
        FileInputStream fileInputStream;
        Boolean exito=false;

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

            // Create file  
            OutputStream out = new FileOutputStream("out.pdf");

//          CON CUALQUIERA DE LOS DOS MÉTODOS SIRVE.            
            out.write(bArray);
//            out.close();

//            for (Byte b : bArray) {
//                out.write(b);
//            }
            
            out.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
