package com.example.lab5.db;

public class User {
    int id;
    String login;
    String pass;

    public User(){
    }
    public User(int id, String login, String pass){
        this.id = id;
        this.login = login;
        this.pass = pass;
    }
    public User(String login, String pass){
        this.login = login;
        this.pass = pass;
    }

    public int getID(){
        return this.id;
    }
    public void setID(int id){
        this.id = id;
    }

    public String getLogin(){
        return this.login;
    }
    public void setLogin(String login){
        this.login = login;
    }

    public String getPass(){
        return this.pass;
    }
    public void setPass(String pass){
        this.pass = pass;
    }
}
