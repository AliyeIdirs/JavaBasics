package com.unitedcoder.homework.week10day1class;

public class NewsLetter {

    private String subject;
    private String senderName;
    private String senderEmail;

    public NewsLetter() {
    }

    public NewsLetter(String subject, String senderName, String senderEmail) {
        this.subject = subject;
        this.senderName = senderName;
        this.senderEmail = senderEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }
}

class NewsLetterTest{
    public static void main(String[] args) {
        NewsLetter newsLetter= new NewsLetter();
        newsLetter.setSubject("New Product Launch.");
        newsLetter.setSenderName("Johnson Clark");
        newsLetter.setSenderEmail("jc@gmail.com");
        System.out.println(newsLetter.getSubject());
        System.out.println(newsLetter.getSenderName());
        System.out.println(newsLetter.getSenderEmail());

    }
}
