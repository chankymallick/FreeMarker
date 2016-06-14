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
@WebServlet(name = "JavaMailAPI", urlPatterns = {"/JavaMailAPI"})
public class JavaMailAPI extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GMail mail = new GMail();
        String To = req.getParameter("to");
        String Message = req.getParameter("Message");
        String mid = req.getParameter("mid");
        String createdby = req.getParameter("createdby");
        String pname = req.getParameter("pname");
        String mname = req.getParameter("mname");      
        
        if (mail.sendMailUsingJavaMailAPI(To,Message,req,mid,createdby,pname,mname)) {
            resp.getWriter().print("Mail Sent Succesfully Using Java Mail API");
        } else {
            resp.getWriter().print("Mail Not Sent");
        }
    }

}
