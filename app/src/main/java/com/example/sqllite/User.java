package com.example.sqllite;

public class User {
    private int id;
    private String name;
    private String password; // Optionnel si vous ne voulez pas afficher le mot de passe

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
