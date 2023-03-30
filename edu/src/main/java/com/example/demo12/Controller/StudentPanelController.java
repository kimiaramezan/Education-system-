package com.example.demo12.Controller;

import com.example.demo12.Model.Course;
import com.example.demo12.Model.GradeReport;
import com.example.demo12.Model.Student;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class StudentPanelController {

    public Label nameLable;
    public Label idLable;
    public ListView ShowAllCourses;
    public TextField theCourseStAdd;
    public ChoiceBox STchoosecourse;
    public ListView loginStudentName;
    public ListView LoginStudentID;
    public ListView STShowGrades;
    public ListView creditlist;
    boolean isclicked=false;


    public void initialize() {
        loginStudentName.getItems().add(Student.getLoginStudent().getName());
        LoginStudentID.getItems().add(Student.getLoginStudent().getStudentID());
        Student student=Student.getLoginStudent();
        for(int i=0;i<student.getCourses().size();i++){
            creditlist.getItems().add(student.getCourses().get(i).getName()+"  (credit) : "+student.getCourses().get(i).getCredits());
        }
    }


    public void showAllCourses(ActionEvent actionEvent) {

        for (Course course : Course.getCourses()) {
            if(!isclicked) {
                System.out.println("1");
                ShowAllCourses.getItems().add(course.getName());
            }
        }
        isclicked=true;

    }


    public void AddtheCourse(ActionEvent actionEvent) {
        Student student=Student.getLoginStudent();
        for (Course course : Course.getCourses()) {
            if (course.getName().equals(STchoosecourse.getValue())) {
                if( !Student.getLoginStudent().getCourses().contains(course)) {
                    Student.getLoginStudent().takeCourse(course);
                    creditlist.getItems().add(course.getName()+"  (credit) : "+course.getCredits());
                }
            }
        }
        clearChoicebox();
    }

    private void clearTextBox() {
        theCourseStAdd.clear();
    }

    public void showAllcoursestochoose(MouseEvent mouseEvent) {
        STchoosecourse.getItems().clear();
        for (Course course : Course.getCourses()) {
            STchoosecourse.getItems().add(course.getName());
        }
    }

    public void getbacktomainmenu(ActionEvent actionEvent) {
        changeScenecontroller.changeMenu("main");
    }

    public void showGrade(ActionEvent actionEvent) {
        Student student=Student.getLoginStudent();
        if(student.getGrades().size()==0){
            STShowGrades.getItems().add("there is no garde!");
        }
        else {
            for (int i = 0; i < student.getGrades().size(); i++) {
                STShowGrades.getItems().add(student.getGrades().get(i));
            }
        }
    }
    public void clearChoicebox(){
        STchoosecourse.setValue("");
    }
}
