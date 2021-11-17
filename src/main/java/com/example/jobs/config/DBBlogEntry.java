package com.example.jobs.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBBlogEntry {
    public DBBlogEntry(){}
    public static ArrayList<String> getName(Connection connection) throws SQLException{
        ArrayList<String> s = new ArrayList<>();
        String sql = "select name from 'users'";

        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();

        while (rs.next()){
            String name = rs.getString("name");
            if (!s.contains(name)){
                s.add(name);
            }
        }
        return s;
    }
    public static ArrayList<String> getLastname(Connection connection, String name) throws SQLException{
        ArrayList<String> s = new ArrayList<>();
        String sql = "select lastname from 'users' where name = ?";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, name);

        ResultSet rs = pstm.executeQuery();

        while (rs.next()){
            String lastname = rs.getString("lastname");
            if (!s.contains(lastname)){
                s.add(lastname);
            }
        }
        return s;
    }
    public static ArrayList<String> getLogin(Connection connection, String name, String lastname) throws SQLException{
        ArrayList<String> s = new ArrayList<>();
        String sql = "select login from 'users' where name = ? and lastname = ?";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, name);
        pstm.setString(2,lastname);

        ResultSet rs = pstm.executeQuery();

        while (rs.next()){
            String login = rs.getString("login");
            if (!s.contains(login)){
                s.add(login);
            }
        }
        return s;
    }
    public static ArrayList<String> getPassword(Connection connection, String name, String lastname, String login) throws SQLException{
        ArrayList<String> s = new ArrayList<>();
        String sql = "select password from 'users' where name = ? and lastname = ? and login = ?";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, name);
        pstm.setString(2, lastname);
        pstm.setString(3,login);

        ResultSet rs = pstm.executeQuery();

        while (rs.next()){
            String password = rs.getString("password");
            if (!s.contains(password)){
                s.add(password);
            }
        }
        return s;
    }
    public static class BlogEntryWork {
        public BlogEntryWork (){}
        public ArrayList<String> getName(Connection connection){
            ArrayList<String> s = null;

            try {
                s = DBBlogEntry.getName(connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return s;
        }
        public ArrayList<String> getLastname(Connection connection, String name){
            ArrayList<String> s = null;

            try {
                s = DBBlogEntry.getLastname(connection, name);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return s;
        }
        public ArrayList<String> getLogin(Connection connection, String name, String lastname){
            ArrayList<String> s = null;

            try {
                s = DBBlogEntry.getLogin(connection, name, lastname);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return s;
        }
        public ArrayList<String> getPassword(Connection connection,String name, String lastname, String login){
            ArrayList<String> s = null;

            try {
                s = DBBlogEntry.getPassword(connection, name, lastname, login);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return s;
        }
    }

}
