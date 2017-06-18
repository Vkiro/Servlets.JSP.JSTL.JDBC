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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Item> items = ItemDAO.INSTANCE.getAllByUserId((Integer) req.getSession().getAttribute("id"));
        req.setAttribute("items", items);
        req.getRequestDispatcher("/item.jsp").forward(req, resp);
        System.out.println(req.getSession().getAttribute("id"));
    }
}
