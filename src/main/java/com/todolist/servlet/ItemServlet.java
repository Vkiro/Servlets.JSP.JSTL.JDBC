package com.todolist.servlet;

import com.todolist.dao.ItemDAO;
import com.todolist.entity.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/item")
public class ItemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Item> items = ItemDAO.INSTANCE.getAllByUserId((Integer) request.getSession().getAttribute("id"));
        request.setAttribute("items", items);
        request.getRequestDispatcher("/item.jsp").forward(request, response);
    }
}
