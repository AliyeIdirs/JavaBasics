package com.unitedcoder.emailutility;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Date;
import java.util.Properties;

import static com.unitedcoder.cubecartautomation.UiUtility.readConfig;

/**
 * @author : user
 * @created : 25.10.2023,11:11
 * @Email :aliyeidiris@gmail.com
 **/
public class SendEmail {
    public static void main(String[] args) throws MessagingException {
        final String smtpHost=readConfig("SmtpServer");
        final String smtpPort=readConfig("SmtpPort");
        final String fromUser=readConfig("SmtpUserName");
        final String fromUserPassword=readConfig("SmtpPassword");
        final String emailTo=readConfig("SmtpEmailTo");
        SendEmail smtpMailSender=new SendEmail();
        smtpMailSender.postEmail(smtpHost,smtpPort,fromUser,fromUserPassword,emailTo,"Common Library Test",
                "This is a test");
        System.out.println("Successfully sent mail to all receivers.");
    }

    public void postEmail(String smtpHostName,String smtpPort, final String fromUser,final String fromUserPassword,
                          String receiver,String subject, String emailContent) throws MessagingException {
        boolean debug=false;
        // set the host smtp address
        Properties properties=new Properties();
        properties.put("mail.smtp.host",smtpHostName);
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.port",smtpPort);

        Session session=Session.getDefaultInstance(properties,
                new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(fromUser,fromUserPassword);
            }
                });
        session.setDebug(debug);
        //create a message
        String [] to =receiver.split(",");
        Message msg=new MimeMessage(session);
        //set the from and to address
        InternetAddress addressFrom= null;
        try {
            addressFrom = new InternetAddress(fromUser);
                msg.setFrom(addressFrom);
                //setting the subject and content type
            msg.setSubject(subject);
            msg.setContent(emailContent,"text/html");
            Transport.send(msg);
        } catch (AddressException e) {
            throw new RuntimeException(e);
        }

    }
    public void postMailWithAttachment(String smtpHostName,String smtpPort,final String fromUser,final String fromUserPassword,
                                       String receiver,String subject,String emailContent, String[] fileNames) throws MessagingException {
        boolean debug=false;
        //Set the host smtp address
        Properties properties=new Properties();
        properties.put("mail.smtp.host",smtpHostName);
        properties.put("mail.smtp.port",smtpPort);
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        Session session=Session.getInstance(properties,
                new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(fromUser,fromUserPassword);
            }
                });
        session.setDebug(debug);
        //create a message
        String [] to =receiver.split(",");
        Message msg=new MimeMessage(session);
        //set the from and to address
        InternetAddress addressFrom=new InternetAddress(fromUser);
        msg.setFrom(addressFrom);
        InternetAddress[] addressTo=new InternetAddress[to.length];
        try {
        for (int i=0;i< to.length;i++){
                addressTo[i]=new InternetAddress(to[i]);
        }
        msg.setRecipients(Message.RecipientType.TO, addressTo);
        //Setting the subject and content type
            //Set subject:header field
            msg.setSubject(subject);
            //Create the message part
            MimeBodyPart messageBodyPart=new MimeBodyPart();
            //Fill the message
            String _CONTENT_HTML="test/html";
            messageBodyPart.setText(emailContent);
            messageBodyPart.setContent(emailContent,_CONTENT_HTML);
            //Create a multipart message and add multiple attachments
            Multipart multipart=new MimeMultipart("mixed");
            multipart.addBodyPart(messageBodyPart);
            //Attach the file for sending
            for (int i=0; i< fileNames.length;i++){
                MimeBodyPart mbp=new MimeBodyPart();
                DataSource source=new FileDataSource(fileNames[i]);
                mbp.setDataHandler(new DataHandler(source));
                mbp.setFileName(fileNames[i]);
                multipart.addBodyPart(mbp);
            }
            msg.setContent(multipart);
            msg.setSentDate(new Date());
            //msg.setContent(emailContent,"text/plain");
            Transport.send(msg);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
