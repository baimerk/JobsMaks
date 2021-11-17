package com.example.jobs.controller;

import com.example.jobs.config.DBWorkTableSQL;
import com.example.jobs.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create")
public class CreateNewServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jobs/pages/create.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String lastname = req.getParameter("lastname");
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            int age = Integer.parseInt(req.getParameter("age"));
            User user = new User(id, name, lastname, login, password, age);
            DBWorkTableSQL.insert(user);
            resp.sendRedirect(req.getContextPath()+"/jobs/pages/main_index.jsp");
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/jobs/pages/create.jsp").forward(req, resp);
        }
    }
}
