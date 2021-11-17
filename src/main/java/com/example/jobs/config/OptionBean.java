package com.example.jobs.config;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OptionBean implements Serializable {
    private static final String SQL_QUERY = "select name from users;";
    private List<String> options;

    public List<String> OptionBean() {
        options = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobs", "root", "password")) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL_QUERY);
            while (rs.next()) {
                options.add(rs.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return options;
    }
}

