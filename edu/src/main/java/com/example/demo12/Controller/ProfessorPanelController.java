package com.example.demo12.Controller;

import com.example.demo12.Model.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;
import java.util.ArrayList;
import java.util.List;

import static com.example.demo12.Model.Course.courses;
import static com.example.demo12.Model.Professor.professors;
import static com.example.demo12.Model.Student.students;

public class ProfessorPanelController {


    public ListView loginProfessorName ;
    public ListView LoginProfessorDepartment ;
    public ListView professorsIntheDep;
    public ListView professorCoursesList  ;
    public ListView ShowSt;
    public TextField Stname;
    public TextField theGrade;
    public TextField stId;
    public TextField StCourse;
    public TextField STnameforW;
    public TextField StIDforW;
    public TextField CoursenameTextbox;


    public void initialize() {
        loginProfessorName.getItems().add(Professor.getLoginProfessor().getName());
        LoginProfessorDepartment.getItems().add(Professor.getLoginProfessor().getDepartment());
        for (Professor professor :professors){
            if(Professor.getLoginProfessor().getDepartment().equals(professor.getDepartment())){
                professorsIntheDep.getItems().add(professor.getName());
            }
        }
        for(Course course :courses){
            if(Professor.getLoginProfessor().getCourses().contains(course))
                professorCoursesList.getItems().add(course.getName());
        }


    }


    public void getbacktomainmenu(ActionEvent actionEvent) {
            changeScenecontroller.changeMenu("main");
        }


    public void ShowStudents(MouseEvent mouseEvent) {
        clearListView();
        Course.getCourse(professorCoursesList.getSelectionModel().getSelectedItem().toString());
        for(Student student : students){
            if(student.getStudentCourses().contains(Course.getCourseByName(professorCoursesList.getSelectionModel().getSelectedItem().toString()))){
                ShowSt.getItems().add(student.getName());

            }
        }

    }

    private void clearListView() {
        ShowSt.getItems().clear();
    }


    public void SubmitGrade(ActionEvent actionEvent) {
        Student student = Student.findStudent(stId.getText(),Stname.getText());
        Course course = Course.getCourseByName(StCourse.getText());
        double grade = Double.parseDouble(theGrade.getText());
        GradeReport gradeReport = new GradeReport(course,student,grade);
        boolean has=false;
        for (Course course2 :courses){
            if(student.getStudentCourses().contains(course)){
                System.out.println(student.getStudentCourses());
                System.out.println("darad");
                has=true;
            }
        }
        if(has) {
            student.settheGrades(gradeReport);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Student doesnt have this course!");
            alert.show();
        }
        clearTextBox();
    }

    public void WStudent(ActionEvent actionEvent) {
        Student student = Student.findStudent(StIDforW.getText(),STnameforW.getText());
        Course course = Course.getCourseByName(CoursenameTextbox.getText());
        GradeReport grade = GradeReport.findGrade(course,student);
        for(int i=0;i<student.getCourses().size();i++){
            if(student.getCourses().get(i).equals(course)){
                student.getStudentCourses().remove(student.getCourses().get(i));
                student.removetheGrade(grade,student);
                System.out.println(student.getGrades());
            }
        }
        clearTextBox();
    }
    private void clearTextBox() {
        Stname.setText("");
        theGrade .setText("");
        stId.setText("");
        StCourse.setText("");
        STnameforW.setText("");
        StIDforW.setText("");
        CoursenameTextbox.setText("");
    }



}
