package com.unitedcoder.emailutility;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * @author : user
 * @created : 25.10.2023,12:45
 * @Email :aliyeidiris@gmail.com
 **/
public class SendSimpleTestEmail {
    public static void main(String[] args) {
        //Initialize a new email instance
        Email email = new SimpleEmail();
        //Set email host
        email.setHostName("smtp.googlemail.com");
        //Set email authentication username and password
        email.setAuthenticator(new DefaultAuthenticator("Selenium Master User Name", "Selenium Master User Password"));
        //Set email host SSL to true
        email.setSSLOnConnect(true);
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
        try {
            //Send Email
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }

    }
}
