/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freemarker.mail;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mallick
 */
@WebServlet(name = "SendMail", urlPatterns = {"/SendMail"})
public class SendMailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String To = req.getParameter("to");
            String Message = req.getParameter("Message");
            GMail sendmailObj = new GMail();
            if (sendmailObj.SendMail(To, Message)) {
                resp.getWriter().write("Mail Sent Succesfully");
            } else {
                resp.getWriter().write("Mail not sent");
            }
        } catch (Exception e) {

        }

    }

}
