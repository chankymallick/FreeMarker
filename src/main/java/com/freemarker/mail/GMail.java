/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freemarker.mail;

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

    public boolean SendMail(String To, String MessageContent,HttpServletRequest req) throws Exception {
        setMailsender();
        String FinalMessage = new FreeMarkerMailTemplateCreater().createAndReturnTemplateData(MessageContent,getTemplateLocation(req));
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
        return req.getServletContext().getRealPath("index.html").substring(0, req.getServletContext().getRealPath("index.html").indexOf("FreeMarkerPOC")+14)+"src\\main\\webapp\\FreeMarkerTemplates\\";
    }
    public String getXMLocation(HttpServletRequest req) {      
        return req.getServletContext().getRealPath("index.html").substring(0, req.getServletContext().getRealPath("index.html").indexOf("FreeMarkerPOC")+14)+"src\\main\\webapp\\FreeMarkerTemplates\\";
    }

}
