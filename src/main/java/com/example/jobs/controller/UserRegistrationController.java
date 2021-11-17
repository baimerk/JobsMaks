package com.example.jobs.controller;

import com.example.jobs.entities.Role;
import com.example.jobs.entities.User;
import com.example.jobs.service.BaseService;
import com.example.jobs.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

@WebServlet("/registration")
public class UserRegistrationController extends HttpServlet {

    private BaseService<User> userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String lastname = req.getParameter("lastname");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        int age = Integer.parseInt(req.getParameter("age"));
        String role = req.getParameter("role");

        Role role1 = Role.valueOf(role.toUpperCase(Locale.ROOT));

        User user = new User(name, lastname, login, password);
        user.setRole(role1);
        user.setAge(age);
        userService.save(user);
        HttpSession session = req.getSession();
        session.setAttribute("user", user);

        String path = req.getContextPath() + "/index.jsp";
        resp.sendRedirect(path);

    }
}