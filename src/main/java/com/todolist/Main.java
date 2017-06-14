package com.todolist;

import com.todolist.dao.UserDAO;
import com.todolist.entity.User;

public class Main {
    public static void main(String[] args) {
        User user = UserDAO.INSTANCE.getById(1);
        System.out.println(user);
    }
}
