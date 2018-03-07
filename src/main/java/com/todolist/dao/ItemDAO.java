package com.todolist.dao;

import com.todolist.entity.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public enum ItemDAO {
    INSTANCE;

    public List<Item> getAllByUserId(int id) throws ExceptionDAO {
        String query = "SELECT id, text, userId FROM Item WHERE userId = ?";
        List<Item> items = new ArrayList<>();
        try (Connection connection = DBConnection.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Item item = new Item();
                    item.setId(resultSet.getInt("id"));
                    item.setText(resultSet.getString("text"));
                    item.setUserId(resultSet.getInt("userId"));
                    items.add(item);
                }
            } catch (SQLException sqle) {
                throw new ExceptionDAO("Can`t execute query", sqle);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new ExceptionDAO("Can`t execute query", e);
        }
        return items;
    }

    public Item getById(int id) throws ExceptionDAO {
        String query = "SELECT id, text, userId FROM Item WHERE id = ?";
        Item item;
        try (Connection connection = DBConnection.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                item = new Item();
                item.setId(resultSet.getInt("id"));
                item.setText(resultSet.getString("text"));
                item.setUserId(resultSet.getInt("userId"));
            } catch (SQLException sqle) {
                throw new ExceptionDAO("Can`t execute query", sqle);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new ExceptionDAO("Can`t execute query", e);
        }
        return item;
    }

    public void create(Item item) throws ExceptionDAO {
        String query = "INSERT INTO Item (text, userId) VALUES (?, ?)";
        try (Connection connection = DBConnection.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, item.getText());
            statement.setInt(2, item.getUserId());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new ExceptionDAO("Can`t execute query", e);
        }
    }

    public void updateTextById(String text, int id) throws ExceptionDAO {
        String query = "UPDATE Item SET text = ? WHERE id = ?";
        try (Connection connection = DBConnection.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, text);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new ExceptionDAO("Can`t execute query", e);
        }
    }

    public void deleteById(int id) throws ExceptionDAO {
        String query = "DELETE FROM Item WHERE id = ?";
        try (Connection connection = DBConnection.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new ExceptionDAO("Can`t execute query", e);
        }
    }
}
