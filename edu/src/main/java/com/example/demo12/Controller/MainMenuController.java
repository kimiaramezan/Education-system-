package com.example.demo12.Controller;

import com.example.demo12.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainMenuController {
    @FXML
    public Button godsModeButton;

    @FXML
    public void openGodsMode(ActionEvent actionEvent) throws IOException {
//        Main.stage.setTitle("Gods Mode");
//        Main.stage.setScene(new Scene(Main.godsPane));
//        Main.stage.show();
        changeScenecontroller.changeMenu("godspanel");

    }
    public void openStudentMode(ActionEvent actionEvent) throws IOException {
        changeScenecontroller.changeMenu("studentLogin");


    }

    public void openProfessorMode(ActionEvent actionEvent) {
        changeScenecontroller.changeMenu("ProfessorLogin");
    }

    public void openDepMode(ActionEvent actionEvent) {
        changeScenecontroller.changeMenu("depOficerLogin");
    }
}
