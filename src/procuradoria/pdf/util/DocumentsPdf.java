/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procuradoria.pdf.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import procuradoria.crud.ProcuradoriaMethods;
import procuradoria.map.Uztdocs;
import procuradoria.map.UztdocsId;
import procuradoria.map.Uztfase;

/**
 *
 * @author Ivan
 */
public class DocumentsPdf {

    public void CovertPdfToByteArray(String Url, String filename) {
        File file = new File("C:\\bytes.pdf");

        FileInputStream fis;
        try {
            fis = new FileInputStream(file);

            //System.out.println(file.exists() + "!!");
            //InputStream in = resource.openStream();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];

            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum); //no doubt here is 0
                //Writes len bytes from the specified byte array starting at offset off to this byte array output stream.
                System.out.println("read " + readNum + " bytes,");
            }

            byte[] bytes = bos.toByteArray();

            Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
            
            Boolean exito = ProcuradoriaMethods.InsertDocs(new Uztdocs(new UztdocsId(BigDecimal.ZERO, new BigDecimal(300), new BigDecimal(600))
                    ,new Uztfase(), filename, filename, filename, blob));
            System.out.println(""+exito);
            //below is the different part
            File someFile = new File("java2.pdf");
            FileOutputStream fos = new FileOutputStream(someFile);
            fos.write(bytes);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DocumentsPdf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DocumentsPdf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DocumentsPdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
