package com.unitedcoder.emailutility;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

/**
 * @author : user
 * @created : 25.10.2023,12:38
 * @Email :aliyeidiris@gmail.com
 **/
public class SendEmailWithAttachment {
    public static void main(String[] args)
       {
                 //Create Attachment
                 EmailAttachment emailAttachment=new EmailAttachment();
                 emailAttachment.setPath("Tulips.jpg");
                 emailAttachment.setDisposition(EmailAttachment.ATTACHMENT);
                 emailAttachment.setDescription("Picture Attachment");
                 emailAttachment.setName("Picture");
                 //Initialize a new multi part email instance
                 MultiPartEmail email=new MultiPartEmail();
                 //Set email host
                 email.setHostName("smtp.googlemail.com");
                 //Set email authentication username and password
                 email.setAuthenticator(new DefaultAuthenticator("Selenium Master User Name","Selenium Master User Password"));
                 //Set email host SSL to true
                 email.setSSL(true);
                 try {
                          //Set From email address
                          email.setFrom("services@seleniummaster.com");
                      } catch (EmailException e) {
                          e.printStackTrace();
                      }
                 //Set email Subject line
                 email.setSubject("Java Test Email");
                 try {
                          //Set Email Message
                          email.setMsg("This is a test from Java Email");
                      } catch (EmailException e) {
                          e.printStackTrace();
                      }
                  try {
                          //Set Email To Address
                          email.addTo("services@seleniummaster.com");
                      } catch (EmailException e) {
                          e.printStackTrace();
                      }
                  //add the attachment
                  try {
                           email.attach(emailAttachment);
                       } catch (EmailException e) {
                           e.printStackTrace();
                       }
                  try {
                           //Send Email
                           email.send();
                       } catch (EmailException e) {
                           e.printStackTrace();
                       }
              }

}
