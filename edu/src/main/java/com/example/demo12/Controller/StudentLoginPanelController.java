package com.example.demo12.Controller;

import com.example.demo12.Main;
import com.example.demo12.Model.Student;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class StudentLoginPanelController {


    public TextField namefield;
    public TextField idfield;
    public Button login;
    public Button backtomainMenu;


    public void clicklogin(ActionEvent actionEvent) {
        Student student = Student.findStudent(idfield.getText(),namefield.getText());
        if(student==null){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Student not found");
        alert.showAndWait();
        }
        else{
            Student.setLoginStudent(student);
//            Main.stage.setScene(new Scene(Main.studentPanel));
//            Main.stage.show();
            changeScenecontroller.changeMenu("studentpanel");

        }
    }

    public void getbacktoMenu(ActionEvent actionEvent) {
        changeScenecontroller.changeMenu("main");
    }
}
