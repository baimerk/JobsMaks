package com.example.jobs.config;


import com.example.jobs.entities.Role;
import com.example.jobs.entities.User;

import java.sql.*;
import java.util.ArrayList;

public class DBWorkTableSQL {
    private static String url = "jdbc:mysql://localhost:3306/jobs?serverTimezone=Europe/Moscow&useSSL=false";
    private static String login = "root";
    private static String password = "password";

    public static ArrayList<User> select() {

        ArrayList<User> select = new ArrayList<User>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
                while(resultSet.next()){
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String lastname = resultSet.getString(3);
                    String login = resultSet.getString(4);
                    String password = resultSet.getString(5);
                    int age = resultSet.getInt(6);
                    User user = new User(id, name ,lastname, login, password, age);
                    select.add(user);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println(select);
        return select;
    }
    public static User selectOne(int id) {

        User user = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){

                String sql = "SELECT * FROM users WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int prod = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        String lastname = resultSet.getString(3);
                        String login = resultSet.getString(4);
                        String password = resultSet.getString(5);
                        int age = resultSet.getInt(6);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return user;
    }
    public static int insert (User user) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){

                String sql = "INSERT INTO users (id, name, lastname, login, password, age) Values (?, ?, ?, ?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, user.getId());
                    preparedStatement.setString(2, user.getName());
                    preparedStatement.setString(3, user.getLastname());
                    preparedStatement.setString(4,user.getLogin());
                    preparedStatement.setString(5,user.getPassword());
                    preparedStatement.setInt(6, user.getAge());

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return 0;
    }

    public static int update(User user) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){

                String sql = "UPDATE users SET name = ?, lastname = ?, login = ?, password = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, user.getName());
                    preparedStatement.setString(2, user.getLastname());
                    preparedStatement.setString(3, user.getLogin());
                    preparedStatement.setString(4, user.getPassword());
                    preparedStatement.setInt(5,user.getAge());
                    preparedStatement.setInt(6,user.getId());

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    public static int delete(int id) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){

                String sql = "DELETE FROM users WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
}
