/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freemarker.freemarkerpoc;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 @author Mallick
 */
@WebServlet(name = "FreemarkerServlet", urlPatterns = {"/FreemarkerServlet"})
public class FreemarkerServlet extends HttpServlet {

    private static ArrayList<Student> Studentlist = new ArrayList<Student>();
    static {
        Studentlist.add(new Student("100", "Chanky"));
        Studentlist.add(new Student("101", "Mallick"));
        Studentlist.add(new Student("102", "Bijay"));
        Studentlist.add(new Student("103", "Ctal"));
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("student", Studentlist);
        req.getRequestDispatcher("FreeMarkerTemplates/StudentTemplate.ftl").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("id");
        String lastname = req.getParameter("name");
        if (null != firstname && null != lastname
                && !firstname.isEmpty() && !lastname.isEmpty()) {
            synchronized (Studentlist) {
                Studentlist.add(new Student(firstname, lastname));
            }
        }
        doGet(req, resp);
    }

}
