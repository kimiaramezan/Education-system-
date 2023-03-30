package com.example.demo12.Controller;

import com.example.demo12.Main;
import com.example.demo12.Model.Professor;
import com.example.demo12.Model.Student;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class ProfessorLoginPanelController {

    public TextField ProfessorName;
    public TextField ProfessorDepartment;

    public void ProfessorClickLogin(ActionEvent actionEvent) {
        Professor professor = Professor.findProfessor(ProfessorName.getText(),ProfessorDepartment.getText());
        System.out.println('1');
        if(professor==null){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Professor not found");
            alert.showAndWait();
        }
        else{
//            Professor.setLoginProfessor(professor);
//            Main.stage.setScene(new Scene(Main.professorPanel));
//            Main.stage.show();
            Professor.setLoginProfessor(professor);
            changeScenecontroller.changeMenu("ProfessorPanel");


        }
    }


    public void backtoMenu(ActionEvent actionEvent) {
        changeScenecontroller.changeMenu("main");
    }
}
