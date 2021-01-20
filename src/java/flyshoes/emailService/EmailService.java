package flyshoes.emailService;

import flyshoes.seguridad.Seguridad;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Lorena Cáceres Manuels
 */
public class EmailService {

    // Server mail user & pass account
    private ResourceBundle rb = ResourceBundle.getBundle("flyshoes.propiedades.parametros");  
    private String user = Seguridad.desencriptarContrasenia(getFile(rb.getString("user")));
    private String pass = Seguridad.desencriptarContrasenia(getFile(rb.getString("pass")));

    // DNS Host + SMTP Port
    private String smtp_host = rb.getString("smtp_host");
    private int smtp_port = Integer.parseInt(rb.getString("smtp_port"));

    private Logger LOGGER = Logger.getLogger(EmailService.class.getName());

    public EmailService() {
    }

    /**
     * Builds the EmailService.
     *
     * @param user User account login
     * @param pass User account password
     * @param host The Server DNS
     * @param port The Port
     */
    public EmailService(String user, String pass, String host, int port) {
        this.user = user;
        this.pass = pass;
        this.smtp_host = host;
        this.smtp_port = port;
    }

    /**
     * Sends the given <b>text</b> from the <b>sender</b> to the
     * <b>receiver</b>. In any case, both the <b>sender</b> and <b>receiver</b>
     * must exist and be valid mail addresses. The sender, mail's FROM part, is
     * taken from this.user by default<br/>
     * <br/>
     *
     * Note the <b>user</b> and <b>pass</b> for the authentication is provided
     * in the class constructor. Ideally, the <b>sender</b> and the <b>user</b>
     * coincide.
     *
     * @param receiver The mail's TO part
     * @param subject The mail's SUBJECT
     * @param text The proper MESSAGE
     * @throws MessagingException Is something awry happens
     *
     */
    public void sendMail(String receiver, String subject, String text) throws MessagingException {

        // Mail properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", smtp_host);
        properties.put("mail.smtp.port", smtp_port);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.trust", smtp_host);
        properties.put("mail.imap.partialfetch", false);

        // Authenticator knows how to obtain authentication for a network connection.
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

        // MIME message to be sent
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(user));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver)); // Ej: receptor@gmail.com
        message.setSubject(subject); // Asunto del mensaje

        // A mail can have several parts
        Multipart multipart = new MimeMultipart();

        // A message part (the message, but can be also a File, etc...)
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(text, "text/html");
        multipart.addBodyPart(mimeBodyPart);

        // Adding up the parts to the MIME message
        message.setContent(multipart);

        // And here it goes...
        Transport.send(message);
    }

    public static String getFile(String path) {

        InputStream keyfis = EmailService.class.getClassLoader()
                .getResourceAsStream(path);
        
        ByteArrayOutputStream os = null;
        byte[] buffer = new byte[1024];
        try {
            os = new ByteArrayOutputStream();
            int len;
            while ((len = keyfis.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
            keyfis.close();
        } catch (IOException e) {

        }
        return os.toString();
    }

    /**
     * Cargar clave pública
     *
     * @param fileName
     * @return clave publica
     * @throws Exception
     */
    private static String fileReader(String path) {
        // System.out.println(System.getProperty("user.dir"));
        byte ret[] = null;
        File file = new File(path);
        try {
            ret = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new String(ret));
        return new String(ret);
    }


}