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
            log.level.info(">> IO PDF: " + ex.getMessage());
        } catch (SQLException ex) {
            log.level.info(">> SQL PDF: " + ex.getMessage());
        }
        return exito;
    }

    public static Boolean CovertPdfToByteArray(Uzatdocs docs, String Url, InputStream input) {

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
            log.level.info(">> FileNotFoundException " + ex.getMessage());
        } catch (IOException ex) {
            log.level.info(">> IOExceptionn " + ex.getMessage());
        } catch (SQLException ex) {
            log.level.info(">> SQLException " + ex.getMessage());
        }

        return exito;
    }

    public static Boolean CovertPdfToByteArray(Uzatdocs docs, String Url) {
        Boolean exito = false;
        try {
            InputStream inputStream = null;
            OutputStream outputStream = null;

            File outputFile = new File(Url);

            inputStream = docs.getUzatdocsPdf();
            outputStream = new FileOutputStream(outputFile);
            byte[] buffer = new byte[25600];
            int bytesRead = 0;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }

            exito = ProcuradoriaMethods.InsertDocumemts(docs, Url);

        } catch (FileNotFoundException ex) {
            log.level.info(">> FileNotFoundException " + ex.getMessage());
        } catch (IOException ex) {
            log.level.info(">> IOExceptionn " + ex.getMessage());
        }

        return exito;
    }

    public static Boolean CovertPdfToByteArray(Uzatdocs docs, InputStream in) {
        try {
            File file = null;
            byte[] bFile = new byte[(int) file.length()];
            byte[] list = IOUtils.toByteArray(in);
            FileInputStream fileInputStream;
            Boolean exito = false;

            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
            java.sql.Blob blob = null;
            blob = new SerialBlob(bFile);
            docs.setUzatdocsArchivo(blob);
            exito = ProcuradoriaMethods.InsertDocs(docs);

            return exito;

        } catch (IOException ex) {
            log.level.info(">> IOException " + ex.getMessage());
        } catch (SQLException ex) {
            log.level.info(">> SQLException " + ex.getMessage());
        }
        return null;
    }

    public static Boolean CreateFilePDF(Uzatdocs document, String filePath) {
        Boolean exito = false;
        try {
            String fileName = document.getId().getUzatdocsId() + ".pdf";
            Blob blob = document.getUzatdocsArchivo();
            int blobLength = (int) blob.length();
            byte[] bArray = blob.getBytes(1, blobLength);
            OutputStream out = new FileOutputStream(filePath + fileName);
            out.write(bArray);
            out.close();
            exito = true;
        } catch (Exception ex) {
            log.level.info(">> Exception " + ex.getMessage());
        }
        return exito;
    }

    public static void RemoveFilePDF(String filePath) {
        File tmppdf = new File(filePath);
        if (tmppdf.exists()) {
            tmppdf.delete();
        }
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
        } catch (Exception ex) {
            log.level.info(">> Exception " + ex.getMessage());
        }
    }

}
