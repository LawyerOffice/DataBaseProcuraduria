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
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.engine.jdbc.BinaryStream;
import procuradoria.crud.ProcuradoriaCrud;
import procuradoria.map.Uztdocs;
import procuradoria.map.UztdocsId;
import procuradoria.util.ProcuradoriaHibernateSessionHandler;
import procuradoria.util.ProcuraduriaHibernateUtil;

/**
 *
 * @author Dennis
 */
public class prueba_Blob {
    static {
        ProcuraduriaHibernateUtil.init();
    }

    public static Boolean InsertDocs(Uztdocs docs) {
        Boolean exito = false;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (docs != null) {
                exito = ProcuradoriaCrud.insertDocs(docs);
            }
        } catch (Exception ex) {
            System.out.println("ERROR EN LISTTIPOROL : ");
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    System.out.println("delageException " + ex.toString());
                }
            }
        }
        return exito;
    }   
    
    public static void main(String args[])
    {
        FileInputStream in = null;
        try {
            
            
            prueba_Blob pb = new prueba_Blob();
            File blob = new File("C:\\Users\\Dennis\\Desktop\\Tutorial_ARQUITECTURAS_JEE.pdf");
            in = new FileInputStream(blob);
            BinaryStream ds = new BinaryStream() {

                @Override
                public InputStream getInputStream() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public byte[] getBytes() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public long getLength() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void release() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            Uztdocs docs = new Uztdocs(new UztdocsId(new BigDecimal(300),new BigDecimal(600),new BigDecimal(129)),
                    null, null, null, null, null);
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(prueba_Blob.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(prueba_Blob.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
    }
//    public void prueba(){
//        PreparedStatement pstmt = conn.prepareStatement("update blob_table set blob = ? where id = ?");
//        File blob = new File("/path/to/picture.png");
//        FileInputStream in = new FileInputStream(blob);
//
//        // the cast to int is necessary because with JDBC 4 there is 
//        // also a version of this method with a (int, long) 
//        // but that is not implemented by Oracle
//        pstmt.setBinaryStream(1, in, (int)blob.length()); 
//
//        pstmt.setInt(2, 42);  // set the PK value
//        pstmt.executeUpdate();
//        conn.commit();
//    }
}
