package com.todolist.servlet;

import com.todolist.dao.ExceptionDAO;
import com.todolist.dao.UserDAO;
import com.todolist.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/findUser")
public class FindUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if ("".equals(login) || "".equals(password)) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            try {
                User user = UserDAO.INSTANCE.getByLoginAndPassword(login, password);
                HttpSession session = request.getSession();
                session.setAttribute("id", user.getId());
                request.getRequestDispatcher("/item").forward(request, response);
            } catch (ExceptionDAO edao) {
                request.getRequestDispatcher("/login").forward(request, response);
            }
        }
    }
}