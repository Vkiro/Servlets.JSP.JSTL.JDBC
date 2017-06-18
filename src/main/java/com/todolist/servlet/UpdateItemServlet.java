package com.todolist.servlet;

import com.todolist.dao.ItemDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/updateItem")
public class UpdateItemServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the name of pressed button
        Enumeration enumeration = request.getParameterNames();
        String parameterId = (String) enumeration.nextElement();
        String text = request.getParameter(parameterId);
        int id = Integer.parseInt(parameterId);
        // Update item
        ItemDAO.INSTANCE.updateTextById(text, id);
        // Update page
        request.getRequestDispatcher("/item").forward(request, response);
    }
}
