/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freemarker.mail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 *
 * @author Mallick
 */
public class GMail {

    private JavaMailSenderImpl mailsender;

    public void setMailsender() {
        this.mailsender = (JavaMailSenderImpl) new FileSystemXmlApplicationContext("E:\\AMM_WEBLOGIC_BUILD\\FreeMarkerPOC\\src\\main\\webapp\\WEB-INF\\spring-mail.xml").getBean("mailsender");

    }

    public boolean SendMail(String To, String MessageContent, HttpServletRequest req) throws Exception {
        setMailsender();
        String FinalMessage = new FreeMarkerMailTemplateCreater().createAndReturnTemplateData(MessageContent, getTemplateLocation(req));
        String From = "analytixdstest@gmail.com";
        String Subject = "Freemarker Email Template";
        MimeMessage mimeMessage = mailsender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");

        mimeMessage.setContent(FinalMessage, "text/html");
        helper.setTo(To);
        helper.setSubject("Subject");
        helper.setFrom(From);
        mailsender.send(mimeMessage);

        return true;

    }

    public String getTemplateLocation(HttpServletRequest req) {
        return req.getServletContext().getRealPath("index.html").substring(0, req.getServletContext().getRealPath("index.html").indexOf("FreeMarkerPOC") + 14) + "src\\main\\webapp\\FreeMarkerTemplates\\";
    }

    public String getXMLocation(HttpServletRequest req) {
        return req.getServletContext().getRealPath("index.html").substring(0, req.getServletContext().getRealPath("index.html").indexOf("FreeMarkerPOC") + 14) + "src\\main\\webapp\\FreeMarkerTemplates\\";
    }

    public boolean sendMailUsingJavaMailAPI(String to,String message1,HttpServletRequest req,String mid,String createdby,String pname,String mname) {       
        String FinalMessage = new FreeMarkerMailTemplateCreater().createAndReturnTemplateDataMapping(message1, getTemplateLocation(req),mid,createdby,pname,mname);
        String from = "analytixdstest@gmail.com";
        final String username = "analytixdstest@gmail.com";
        final String password = "analytix000";
        String host = "smtp.gmail.com";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");       
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {           
            Message message = new MimeMessage(session);          
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(to));      
            message.setContent(FinalMessage,"text/html; charset=utf-8");
            message.saveChanges();
            message.setSubject("Analytix Test Mail"); 
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            return false;

        }
    }

}
