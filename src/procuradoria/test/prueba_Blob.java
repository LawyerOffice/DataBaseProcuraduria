/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package procuradoria.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.serial.SerialBlob;
import org.hibernate.LobHelper;
import procuradoria.crud.ProcuradoriaCrud;
import procuradoria.crud.ProcuradoriaMethods;
import procuradoria.map.Uztdocs;
import procuradoria.map.UztdocsId;
import procuradoria.util.ProcuradoriaHibernateSessionHandler;
import procuradoria.util.ProcuraduriaHibernateUtil;

/**
 *
 * @author Dennis
 */
public class prueba_Blob {
   
    public static void main(String args[])
    {
        
        
        String filepath = "C:\\Users\\Dennis\\Desktop\\Tutorial_ARQUITECTURAS_JEE.pdf";
        
        FileInputStream in = null;   
        File file = new File(filepath);     
        byte[] bFile = new byte[(int) file.length()];
        FileInputStream fileInputStream;       
        
        
        try {
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
            java.sql.Blob blob=null;
            blob=new SerialBlob(bFile);      
            Uztdocs docs = new Uztdocs(new UztdocsId(new BigDecimal(300),new BigDecimal(600),new BigDecimal(129)),
                    null, null, null, "prueba2", blob);
            ProcuradoriaMethods.InsertDocs(docs);
        } catch (Exception e) {
                 e.printStackTrace();
        }
        
    }
}
