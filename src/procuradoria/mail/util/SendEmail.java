/* * Company: Ater Bios 
 * Project: Data Access Lib 
 * Creation Date: Nov 21, 2013 
 * 
 * Copyright by AlterBios 
 * */
package procuradoria.mail.util;

import com.logger.L;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Francisco
 */
public class SendEmail {

    private final static L log = new L(SendEmail.class);
    private String destinatario;
    private String subject;
    private String mensaje;
    private Session session;
    private String fileName;
    private Properties props;

    public SendEmail() {
        this.props = new Properties();
    }

    public void setAttachemnt(String attachment) {
        this.fileName = attachment;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void cargarConfiguracion() throws GeneralSecurityException {

        final String username = "no-reply-servicios@espe.edu.ec";
        final String password = "89G%HeBd";

        this.props.put("mail.smtp.host", "smtp.gmail.com");
        this.props.put("mail.smtp.socketFactory.port", "465");
        this.props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        this.props.put("mail.smtp.auth", "true");
        this.props.put("mail.smtp.port", "465");
        this.props.put("mail.smtp.ssl.enable", "true");
        this.props.put("mail.username", "no-reply-servicios@espe.edu.ec");
        this.props.put("mail.password", "89G%HeBd");
        this.props.put("mail.accoun", "no-reply-servicios@espe.edu.ec");
        this.props.put("mail.screenname", "Rapid Loans");

        this.session = Session.getInstance(this.props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
    }

    public boolean enviarCorreo() {
        boolean exito = false;
        try {//this.prop.$MAIL_ACCOUNT, this.prop.$MAIL_SCREEN_NAME)
            MimeMessage message = new MimeMessage(this.session);
            message.setFrom(new InternetAddress(this.props.getProperty("mail.account"), this.props.getProperty("mail.screenname")));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destinatario));
            message.setSubject(subject);

            /**
             * Insert html
             */
            MimeMultipart multipart = new MimeMultipart("related");
            BodyPart html = new MimeBodyPart();
            String htmlText = mensaje;
            html.setContent(htmlText, "text/html; charset=utf-8");
            multipart.addBodyPart(html);
            /**
             * Insert Image
             */
            MimeBodyPart img = new MimeBodyPart();
            File fds = new File(getClass().getResource("/rapidloans/mail/res/acreditacion.png").toURI());
            img.attachFile(fds.getPath());
            img.setHeader("Content-ID", "<@acreditacion>");
            multipart.addBodyPart(img);
            /**
             * add pdf
             */
//            MimeBodyPart pdf = new MimeBodyPart();
//            if (fileName != null && fileName.compareTo("") != 0) {
//                pdf.attachFile(fileName);
//                multipart.addBodyPart(pdf);
//            }
            message.setContent(multipart);
            Transport.send(message);
            exito = true;
        } catch (MessagingException ex) {
            log.level.error("Messaging: " + ex.getMessage());
        } catch (UnsupportedEncodingException ex) {
            log.level.error("Unsupported Encoding Exception: ", ex);
        } catch (URISyntaxException ex) {
            log.level.error("URI Syntax Exception: ", ex);
        } catch (IOException ex) {
            log.level.error("IO Exception: ", ex);
        }
        return exito;
    }
}
