package com.example.demo12;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    public static Pane godsPane;
    public static Pane studentPane;
    public static Stage stage;
    public static Pane mainScene;
    public static Pane studentPanel;
    public static Pane professorPane;
    public static Pane professorPanel;
    public Button GodModeButton;
    public Button StudentModeButton;
    public Button ProfessorModeButton;
    public Button DepartmentOfficerModeButton;

    @Override
    public void start(Stage stage) throws IOException {
//        Main.stage = stage;
//        Pane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
//        mainScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
//        godsPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("godspanel.fxml")));
//        studentPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("studentLogin.fxml")));
//        professorPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("professorLogin.fxml")));
//        studentPanel =FXMLLoader.load(Objects.requireNonNull(getClass().getResource("studentPanel.fxml")));
//        professorPanel = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("professorPanel.fxml")));
//        FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
//        Scene scene = new Scene(pane);
//        stage.setTitle("University Management System!");
//        stage.setScene(scene);
//        stage.show();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("University Management System!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        this.stage = stage;
    }

    public static void main(String[] args) {
        launch();
    }


}