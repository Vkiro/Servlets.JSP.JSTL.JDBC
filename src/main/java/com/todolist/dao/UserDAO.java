package com.todolist.dao;

import com.todolist.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public enum UserDAO {
    INSTANCE;

    public List<User> getAll() throws ExceptionDAO {
        String query = "SELECT id, login, password, firstName, lastName FROM Users";
        ArrayList<User> listUsers = new ArrayList<>();

        try (Connection connection = DBConnection.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));
                listUsers.add(user);
            }
        } catch (SQLException sqle) {
            throw new ExceptionDAO("Can`t execute query", sqle);
        }
        return listUsers;
    }

    public User getById(int id) throws ExceptionDAO {
        String query = "SELECT id, login, password, firstName, lastName FROM Users WHERE id = ?";
        User user;
        try (Connection connection = DBConnection.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));
            } catch (SQLException sqle) {
                throw new ExceptionDAO("Can`t execute query", sqle);
            }
        } catch (SQLException sqle) {
            throw new ExceptionDAO("Can`t execute query", sqle);
        }
        return user;
    }

    public void create(User user) throws ExceptionDAO {
        String query = "INSERT INTO users (fistName, lastName, login, password) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConnection.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getLogin());
            statement.setString(4, user.getPassword());
            statement.executeUpdate();
        } catch (SQLException sqle) {
            throw new ExceptionDAO("Can`t execute query", sqle);
        }
    }

    public void update(User user) throws ExceptionDAO {
        String query = "UPDATE Users SET firstName = ?, lastName = ?, login = ?, password = ? WHERE id = ?";
        try (Connection connection = DBConnection.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getLogin());
            statement.setString(4, user.getPassword());
            statement.setInt(5, user.getId());
            statement.executeUpdate();
        } catch (SQLException sqle) {
            throw new ExceptionDAO("Can`t execute query", sqle);
        }
    }

    public void deleteById(User user) throws ExceptionDAO {
        String query = "DELETE FROM Users WHERE id = ?";
        try (Connection connection = DBConnection.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, user.getId());
        } catch (SQLException sqle) {
            throw new ExceptionDAO("Can`t execute query", sqle);
        }
    }
}