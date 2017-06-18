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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            User user = UserDAO.INSTANCE.getByLoginAndPassword(login, password);
            HttpSession session = req.getSession();
            session.setAttribute("id", user.getId());
            req.getRequestDispatcher("/item").forward(req, resp);
        } catch (ExceptionDAO edao) {
            req.getRequestDispatcher("/login").forward(req, resp);
        }
    }
}