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
        String query = "SELECT id, text, userId FROM Items WHERE userId = ?";
        List<Item> items = new ArrayList<>();
        try (Connection connection = DBConnection.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Item item = new Item();
                    item.setId(resultSet.getInt("id"));
                    item.setText(resultSet.getString("firstName"));
                    item.setUserId(resultSet.getInt("userId"));
                    items.add(item);
                }
            } catch (SQLException sqle) {
                throw new ExceptionDAO("Can`t execute query", sqle);
            }
        } catch (SQLException sqle) {
            throw new ExceptionDAO("Can`t execute query", sqle);
        }
        return items;
    }

    public void create(Item item) throws ExceptionDAO {
        String query = "INSERT INTO Items (text, userId) VALUES (?, ?) WHERE userId = ?";
        try (Connection connection = DBConnection.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, item.getText());
            statement.setInt(2, item.getUserId());
            statement.setInt(3, item.getUserId());
            statement.executeUpdate();
        } catch (SQLException sqle) {
            throw new ExceptionDAO("Can`t execute query", sqle);
        }
    }

    public void update(Item item) throws ExceptionDAO {
        String query = "UPDATE Items SET text = ?, userId = ? WHERE id = ?";
        try (Connection connection = DBConnection.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, item.getText());
            statement.setInt(2, item.getUserId());
            statement.setInt(3, item.getId());
            statement.executeUpdate();
        } catch (SQLException sqle) {
            throw new ExceptionDAO("Can`t execute query", sqle);
        }
    }

    public void delete(Item item) throws ExceptionDAO {
        String query = "DELETE FROM Items WHERE id = ?";
        try (Connection connection = DBConnection.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, item.getId());
        } catch (SQLException sqle) {
            throw new ExceptionDAO("Can`t execute query", sqle);
        }
    }
}
