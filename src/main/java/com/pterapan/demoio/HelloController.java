package com.pterapan.demoio;

import com.google.gson.Gson;
import com.pterapan.demoio.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class HelloController {
    public Label label1;
    public TextArea text1;
    public ListView listKomentar;
    public TextField txtUsername;
    public TextField txtKomentar;

    public void addKomentar(ActionEvent actionEvent) {
        if (!txtUsername.getText().isEmpty() && !txtKomentar.getText().isEmpty()) {
            String username = txtUsername.getText();
            String komentar = txtKomentar.getText();
            User user = new User(username, komentar);
            listKomentar.getItems().add(user);
        } else {
            Alert alertbox = new Alert(Alert.AlertType.INFORMATION, "Please fill in all the fields", ButtonType.OK);
            alertbox.showAndWait();
        }
    }

    public void saveKomentar(ActionEvent actionEvent) {
        BufferedWriter writer;
        String filename = "data/comment.txt";
        try {
            writer = new BufferedWriter(new FileWriter(filename));
            Gson gson = new Gson();
            String komentar = gson.toJson(listKomentar.getItems());
            writer.write(komentar);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadKomentar(ActionEvent actionEvent) {
        BufferedReader reader;
        String filename = "data/comment.txt";
        try {
            reader = new BufferedReader(new FileReader(filename));
            String json = reader.readLine();
            Gson gson = new Gson();
            User[] ulist = gson.fromJson(json, User[].class);
            listKomentar.getItems().addAll(ulist);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveKomentarNio(ActionEvent actionEvent) {
        Path p = Paths.get("data/comment.txt");
        try {
            Gson gson = new Gson();
            String komentar = gson.toJson(listKomentar.getItems());
            Files.write(p, komentar.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadKomentarNio(ActionEvent actionEvent) {
        Path p = Paths.get("data/comment.txt");
        try {
            List<String> json = Files.readAllLines(p);
            Gson gson = new Gson();
            User[] ulist = gson.fromJson(json.get(0), User[].class);
            listKomentar.getItems().addAll(ulist);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}