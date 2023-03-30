package com.example.demo12.Controller;

import com.example.demo12.Model.Department;
import com.example.demo12.Model.Student;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class DepOficerLogin {
    public TextField depName;

    public void login(ActionEvent actionEvent) {
        Department department =Department.getDepartment(depName.getText());
        if(department==null){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Department not found");
            alert.showAndWait();
        }
        else{
            Department.setLoginDep(department);
            changeScenecontroller.changeMenu("DepPanel");
        }
    }

    public void BacktoMenu(ActionEvent actionEvent) {
        changeScenecontroller.changeMenu("main");
    }
}
