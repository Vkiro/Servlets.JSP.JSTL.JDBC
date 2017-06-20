package com.todolist.servlet;

import com.todolist.dao.UserDAO;
import com.todolist.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/createUser")
public class CreateUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        if ("".equals(login) || "".equals(password) || "".equals(firstName) || "".equals(lastName)) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else if (UserDAO.INSTANCE.getAllLogins().contains(login)) {
            //TODO
            request.getRequestDispatcher("/registration").forward(request, response);
        } else if (password.length() < 6) {
            //TODO
            request.getRequestDispatcher("/registration").forward(request, response);
        } else {
            User user = new User(login, password, firstName, lastName);
            UserDAO.INSTANCE.create(user);
            request.getRequestDispatcher("/login").forward(request, response);
        }
    }
}
