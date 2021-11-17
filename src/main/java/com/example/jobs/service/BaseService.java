package com.example.jobs.service;

import java.util.List;

public interface BaseService <T>{
    T findById(int id);
    List<T> findAll();
    boolean deleteById(int id);
    boolean update(T entity);
    boolean save(T entity);

    //String url = properties.getProperty("url");
    //String login = properties.getProperty("login");
    //String password = properties.getProperty("password");
    //String driver = properties.getProperty("driver");
    //Class.forName(driver);
}
