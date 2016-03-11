/* * Company: Ater Bios 
 * Project: Data Access Lib 
 * Creation Date: Nov 22, 2013 
 * 
 * Copyright by AlterBios 
 * */
package procuradoria.mail.util;

import com.logger.L;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;

/**
 *
 * @author Francisco
 */
public class MailTool {

    private static final L log = new L(MailTool.class);

    private static String name;
    private static String link;
    private static String userName;

    public void init(String _name, String _link) {
        name = _name;
        link = _link;
    }

    public void init(String _name, String _link, String _userName) {
        name = _name;
        link = _link;
        userName = _userName;
    }

    public Boolean sendEmailFile(String receiver, String file, String Nombre, String numCausa, String numFase, String lugar, String fecha) {
        Boolean success = false;
        try {
            SendEmail sendEmail = new SendEmail();
            sendEmail.setDestinatario(receiver);
            sendEmail.setSubject("Notificación de Cita - Lawyer Office");
            sendEmail.setSubject("Alerta Lawyeers Office - Atención");
            init("Unidad de Servicios - ESPE", "ningun link");
            sendEmail.setMensaje(getMessageComprobante(Nombre, numCausa, numFase, lugar, fecha));
            sendEmail.setAttachemnt(file);
            sendEmail.cargarConfiguracion();
            success = sendEmail.enviarCorreo();
        } catch (Exception ex) {
            log.level.error("No se envio el correo electrónico.", ex);
            success = false;
        }

        return success;
    }

    private String getMessageComprobante(String Nombre, String numCausa, String numFase, String lugar, String fecha) throws Exception {
        String message = "";
        try {
            byte[] encoded = Files.readAllBytes(new File(MailTool.class.getResource(
                    "/procuradoria/mail/res/mail_cmp.html")
                    .toURI()).toPath());
            Charset encoding = Charset.forName("UTF-8");
            message = encoding.decode(ByteBuffer.wrap(encoded)).toString();
            message = message.replaceAll("XfileNameX", Nombre);
            message = message.replaceAll("XnumCausaX", numCausa);
            message = message.replaceAll("XnumFaseX", numFase);
            message = message.replaceAll("XcitaSalaX", lugar);
            message = message.replaceAll("XcitaFechaX", fecha);

        } catch (IOException ex) {
            log.level.error("No se pudo leer el archivo. IO Exception: ", ex);
            throw ex;
        } catch (URISyntaxException ex) {
            log.level.error("No se pudo leer el archivo. URI Syntax Exception: ", ex);
            throw ex;
        }
        return message;
    }
}
