package Controller.Contact;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

public class Mail {

    public static void sendMail(String recepient, String emailContent) throws MessagingException, UnsupportedEncodingException {
        System.out.println("Prepare to send");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAccount = "hailuatamquan@gmail.com";
        String password = "wxon msix iijy mfsu";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccount, password);
            }
        });

        try {
            Message message = prepareMessage(session, myAccount, recepient, emailContent);
            Transport.send(message);
            System.out.println("Message sent successfully");
        } catch (MessagingException ex) {
            // Handle the exception or rethrow it
            System.out.println("Error sending message: " + ex.getMessage());
            throw ex;
        }
    }

    private static Message prepareMessage(Session session, String myAccount, String recepient, String emailContent) throws MessagingException, UnsupportedEncodingException {
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(myAccount));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recepient));

            // Encode subject with UTF-8
            msg.setSubject(MimeUtility.encodeText("TiTan Land", "UTF-8", "B"));

            // Set content type to ensure proper UTF-8 encoding
            msg.setContent(emailContent, "text/plain; charset=UTF-8");

            return msg;
        } catch (MessagingException ex) {
            // Handle the exception or rethrow it
            System.out.println("Error preparing message: " + ex.getMessage());
            throw ex;
        } catch (UnsupportedEncodingException ex) {
            // Handle the exception or rethrow it
            System.out.println("Error encoding message: " + ex.getMessage());
            throw ex;
        }
    }
}
