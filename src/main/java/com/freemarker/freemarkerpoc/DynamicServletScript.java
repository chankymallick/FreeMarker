/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freemarker.freemarkerpoc;

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
@WebServlet(name = "DynamicServletScript", urlPatterns = {"/DynamicServletScript"})
public class DynamicServletScript extends HttpServlet { 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     req.setAttribute("message","hello");
     req.getRequestDispatcher("FreeMarkerTemplates/DynamicJSTemplate.ftl").forward(req, resp);
    }
}
