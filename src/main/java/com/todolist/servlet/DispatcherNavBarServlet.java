package com.todolist.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dispatcherNavBar")
public class DispatcherNavBarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("about") != null) {
            request.getRequestDispatcher("/about").forward(request, response);
        } else if (request.getParameter("item") != null) {
            request.getRequestDispatcher("/item").forward(request, response);
        } else if (request.getParameter("logout") != null) {
            request.getSession().invalidate();
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
