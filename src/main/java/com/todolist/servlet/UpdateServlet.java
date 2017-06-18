package com.todolist.servlet;

import com.todolist.dao.ItemDAO;
import com.todolist.entity.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the name of pressed button
        Enumeration enumeration = request.getParameterNames();
        String parameterName = (String) enumeration.nextElement();
        // Parse it to int and get Id
        int itemId = Integer.parseInt(parameterName);

        Item item = ItemDAO.INSTANCE.getById(itemId);

        request.setAttribute("item", item);
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }
}
