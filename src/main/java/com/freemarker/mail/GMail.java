/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freemarker.mail;

import javax.mail.internet.MimeMessage;
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

    public boolean SendMail(String To, String MessageContent) throws Exception {
        setMailsender();
        String FinalMessage = new FreeMarkerMailTemplateCreater().createAndReturnTemplateData(MessageContent);
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

}
