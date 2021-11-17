package com.example.jobs.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAppConnection {
    public static void main(String[] args) {
        String create_table_sql = "CREATE TABLE nato (Id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(45), lastname VARCHAR(45), login VARCHAR(45), password VARCHAR(45), Age int)";

        DBConnection connection = new DBConnection();
        try(Connection conn = connection.getConnection();
            Statement statement = conn.createStatement()){
            int result = statement.executeUpdate(create_table_sql);
            System.out.println(result);
        } catch (SQLException exc){
            System.out.println(exc.getErrorCode());
        }

    }
}
