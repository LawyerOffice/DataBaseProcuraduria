/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package procuradoria.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.serial.SerialBlob;
import org.hibernate.LobHelper;
import procuradoria.crud.ProcuradoriaCrud;
import procuradoria.crud.ProcuradoriaMethods;
import procuradoria.util.ProcuradoriaHibernateSessionHandler;
import procuradoria.util.ProcuraduriaHibernateUtil;

/**
 *
 * @author Dennis
 */
public class prueba_Blob {
   
    public static void main(String args[])
    {
//        ArrayList<Uztdocs> docs = new ArrayList<Uztdocs>();
//        
//        docs = ProcuradoriaMethods.FindDocsbyCaso_Fase(new BigDecimal(300),new BigDecimal(600));
//        Blob blob = docs.get(0).getUztdocsArchivo();
//
//        int blobLength;  
//        try {
//            
//            blobLength = (int) blob.length();
//            byte[] blobAsBytes = blob.getBytes(1, blobLength);
//            blob.free();
//            System.out.println(blobAsBytes.toString());
//            
//            OutputStream out = new FileOutputStream("out.pdf");
//            out.write(blobAsBytes);
//            out.close();
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(prueba_Blob.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(prueba_Blob.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(prueba_Blob.class.getName()).log(Level.SEVERE, null, ex);
//        }

        

        //release the blob and free up memory. (since JDBC 4.0)
        
        
    }
}
