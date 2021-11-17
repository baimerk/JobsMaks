package com.example.jobs.config;

import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;

public class Catalogue implements Serializable {
    private DBBlogEntry.BlogEntryWork entryWork;
    private Connection connection;

    public Catalogue(Connection connection){
        entryWork = new DBBlogEntry.BlogEntryWork();
        this.connection = connection;
    }
    // получить имена
    public ArrayList<String> getName() {
        return entryWork.getName(connection);
    }
    // получить вторые имена
    public ArrayList<String> getLastname(String name) {
        return entryWork.getLastname(connection, name);
    }
    // получить логины
    public ArrayList<String> getLogin(String name, String lastname) {
        return entryWork.getLogin(connection, name, lastname);
    }
    // получить пароль
    public ArrayList<String> getPassword(String name, String lastname, String login) {
        return entryWork.getPassword(connection, name, lastname,login);
    }
}
