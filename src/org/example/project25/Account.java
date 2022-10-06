package org.example.project25;

public class Account {
    private String login;
    private String password;
    private String name;
    private String tel;

    public Account(String login, String password, String name, String tel) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.tel = tel;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return login + '\\' + password + '\\' + name + '\\' + tel + '\\';

    }
}