package com.pterapan.demoio.model;

public class User {
    private String username;
    private String komentar;

    @Override
    public String toString() {
        return username + " - " + komentar;
    }

    public User(String username, String komentar) {
        this.username = username;
        this.komentar = komentar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }
}
