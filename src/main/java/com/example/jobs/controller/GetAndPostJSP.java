package com.example.jobs.controller;

import com.example.jobs.config.DBWorkTableSQL;
import com.example.jobs.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/")
public class GetAndPostJSP extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<User> users = DBWorkTableSQL.select();
        req.setAttribute("users", users);

        getServletContext().getRequestDispatcher("/jobs/pages/main_index.jsp").forward(req, resp);
    }
}
