package com.example.jobs.entities;

public class User {
    private int id;
    private String name;
    private String lastname;
    private String login;
    private String password;
    private int age;
    private Role role;

    public User(){
        this.id = id;
    }

    public User(int id, String name, String lastname){
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }

    public User(int id, String name, String lastname, String login, String password, int age) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
        this.age = age;
    }

    public User(String name, String lastname, String login, String password){
        this.name = name;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
    }

    public User(String name, String lastname){
        this.name = name;
        this.lastname = lastname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public Role getRole() {
        return role;
    }


    public User(int id, String name, String lastname, String login, String password, int age, Role role) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
        this.age = age;
        this.role = role;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "User" +
                "id='" + id +
                ",name='" + name + '\'' +
                ",lastname='" + lastname + '\'' +
                ",login=" + login + '\'' +
                ",password='" + password + '\'' +
                ",age='" + age + '\'' +
                ",role='" + role +
                '}';
    }

}
