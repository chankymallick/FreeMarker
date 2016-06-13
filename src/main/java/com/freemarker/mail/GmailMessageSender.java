/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freemarker.mail;

/**
 *
 * @author Mallick
 */
public class GmailMessageSender {

    public static void main(String[] args) throws Exception {
        GMail sendmailObj = new GMail();
        String To = "mallickm@analytixds.com";
        String Message = "Hello this is a test message";
        if (sendmailObj.SendMail(To, Message)) {
            System.out.println("Mail Sent Succesfully");
        } else {
            System.out.println("Mail not sent");
        }
    }

}
