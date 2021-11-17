package com.example.jobs.repository.impl;

import com.example.jobs.config.DBConnection;
import com.example.jobs.entities.Role;
import com.example.jobs.entities.User;
import com.example.jobs.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepositoryImpl implements BaseRepository<User> {
    private static final String INSERT = "INSERT INTO users (name, lastname, login, password, age, role_id) values (?, ?, ?, ? ,?, ?)";
    private static final String DELETE = "DELETE FROM users where id = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM users where id = ?";
    private static final String SELECT_ROLE_BY_NAME = "SELECT * FROM roles where name = ?";

    private final DBConnection connection;
    public UserRepositoryImpl() {
        this.connection = new DBConnection();
    }

    @Override
    public User findById(int id) {
        User user = new User();
        try(Connection conn1 = connection.getConnection();
            PreparedStatement statement = conn1.prepareStatement(SELECT_BY_ID)){
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                user.setId(resultSet.getInt("id"));
            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        try(Connection conn = connection.getConnection();
        PreparedStatement statement = conn.prepareStatement(DELETE)){
            statement.setInt(1,id);
            return statement.executeUpdate() !=0;
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(User entity) {
        return false;
    }

    @Override
    public boolean save(User entity) {
        try(Connection conn = connection.getConnection();
            PreparedStatement statement = conn.prepareStatement(INSERT)){
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getLastname());
            statement.setString(3, entity.getLogin());
            statement.setString(4, entity.getPassword());
            statement.setInt(5,entity.getAge());
            statement.setInt(6, getRoleByName(entity.getRole().toString()));
            return statement.executeUpdate() != 0;
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return false;
    }
    private int getRoleByName(String name){
        int roleId = 0;
        try(Connection conn1 = connection.getConnection();
            PreparedStatement statement = conn1.prepareStatement(SELECT_ROLE_BY_NAME)){
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                roleId = resultSet.getInt("id");
            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return roleId;
    }
}
