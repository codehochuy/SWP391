/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Contact;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ACER
 */
public class Mail {
    public static void sendMail(String recepient, String passWord) throws MessagingException {
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
            Message message = prepareMessage(session, myAccount, recepient, passWord);
            Transport.send(message);
            System.out.println("Message sent successfully");
        } catch (MessagingException ex) {
            // Handle the exception or rethrow it
            System.out.println("Error sending message: " + ex.getMessage());
            throw ex;
        }
    }

    private static Message prepareMessage(Session session, String myAccount, String recepient, String passWord) throws MessagingException {
        try {
            Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(myAccount));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recepient));
            msg.setSubject("TiTan Land");
            String htmlBody = "<html><body>"
                    + "<h1>Welcome to TiTan Land!</h1>"
                    + "</body></html>";

            msg.setContent(htmlBody, "text/html");
            return msg;

        } catch (MessagingException ex) {
            // Handle the exception or rethrow it
            System.out.println("Error preparing message: " + ex.getMessage());
            throw ex;
        }
    }
    
}
