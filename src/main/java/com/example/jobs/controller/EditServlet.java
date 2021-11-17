package com.example.jobs.controller;

import com.example.jobs.config.DBWorkTableSQL;
import com.example.jobs.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            User user = DBWorkTableSQL.selectOne(id);
            if (user != null){
                req.setAttribute("user", user);
                getServletContext().getRequestDispatcher("/edit.jsp").forward(req, resp);
            }
            else {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(req,resp);
            }
        }
        catch (Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String lastname = req.getParameter("lastname");
            User user = new User(id, name, lastname);
            DBWorkTableSQL.update(user);
            resp.sendRedirect(req.getContextPath()+"/main_index");
        }
        catch (Exception ex) {
            getServletContext().getRequestDispatcher("/notfound").forward(req, resp);
        }
    }
}
