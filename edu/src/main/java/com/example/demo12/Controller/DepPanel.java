package com.example.demo12.Controller;

import com.example.demo12.Model.*;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import static com.example.demo12.Model.Course.courses;
import static com.example.demo12.Model.Professor.professors;

public class DepPanel {

    public ListView DepName;
    public ListView ProfList;
    public ListView CourseList;
    public TextField STName;
    public TextField StID;
    public TextField CourseName;
    public TextField StudentNAmetoadd;
    public TextField StudentIDtoAdd;
    public TextField CoursenametoAdd;
    public TextField idTextBox;
    public TextField nameTextBox;
    public DatePicker STBirth;
    public TextField CoursenameTextBox;
    public TextField CourseunitTextBox;
    public ChoiceBox professorCourseChoiceBox;
    public TextField ProfessornameTextBox;
    public DatePicker profBirth;
    public ChoiceBox academic;
    public ListView DepName1;
    public ListView DepName11;

    public void initialize() {
        DepName.getItems().add(Department.getLoginDep().getName());
        DepName1.getItems().add(Department.getLoginDep().getName());
        DepName11.getItems().add(Department.getLoginDep().getName());
        academic.getItems().add(AcademicRank.ASSISTANT_PROFESSOR.getLable());
        academic.getItems().add(AcademicRank.ASSOCIATE_PROFESSOR.getLable());
        academic.getItems().add(AcademicRank.PROFESSOR.getLable());
        System.out.println(Department.getLoginDep().getProfessors().size());
        for(Professor professor :professors){
            if(professor.getDepartment().equals(Department.getLoginDep())) {
                ProfList.getItems().add(professor.getName());
            }
        }
        for(Course course: courses){
            if(course.getDepartment().equals(Department.getLoginDep())){
                CourseList.getItems().add(course.getName());
            }
        }
        for(Professor professor : Professor.getProfessors()){
            professorCourseChoiceBox.getItems().add(professor.getName());
        }

    }

    public void BacktoMenu(ActionEvent actionEvent) {
        changeScenecontroller.changeMenu("main");
    }

    public void removeCourse(ActionEvent actionEvent) {
        Student student = Student.findStudent(StID.getText(),STName.getText());
        Course course = Course.getCourseByName(CourseName.getText());
        for(int i=0;i<student.getCourses().size();i++){
            if(student.getCourses().get(i).equals(course)){
                student.getStudentCourses().remove(student.getCourses().get(i));
            }
        }
        ClearTextBox();
    }


    public void AddcourseforSt(ActionEvent actionEvent) {
        Student student = Student.findStudent(StudentIDtoAdd.getText(),StudentNAmetoadd.getText());
        Course course = Course.getCourseByName(CoursenametoAdd.getText());
        if(student.getStudentCourses().contains(course)){
            Alert alert = new Alert(Alert.AlertType.WARNING,"Student already has this course!");
            alert.show();
        }
        else {
            student.takeCourse(course);
        }
        ClearTextBox();
    }
    

    public void ClearTextBox(){
        StID.setText("");
        STName.setText("");
        CourseName.setText("");
        StudentIDtoAdd.setText("");
        StudentNAmetoadd.setText("");
        CoursenametoAdd.setText("");
        nameTextBox.setText("");
        idTextBox.setText("");
        ProfessornameTextBox.setText("");
        CoursenameTextBox.setText("");
        CourseunitTextBox.setText("");
        professorCourseChoiceBox.setValue(null);
        academic.setValue(null);
        nameTextBox.setText("");
        idTextBox.setText("");
        ProfessornameTextBox.setText("");
        CoursenameTextBox.setText("");
        CourseunitTextBox.setText("");
        professorCourseChoiceBox.setValue("");
        STBirth.setValue(null);
        profBirth.setValue(null);
    }

    public void addtoStudent(ActionEvent actionEvent) {
        Student student = new Student(idTextBox.getText());
        student.setName(nameTextBox.getText());
        student.setBirthDate(STBirth.getValue());
        Student.addStudent(student);
        ClearTextBox();
    }

    public void addtoCourse(ActionEvent actionEvent) {
        Course course = new Course(CoursenameTextBox.getText());
        course.setName(CoursenameTextBox.getText());
        course.setCredits(Integer.parseInt(CourseunitTextBox.getText().toString()));
        course.setDepartment(Department.getLoginDep());
        if(Integer.parseInt(CourseunitTextBox.getText().toString())<0){
            Alert alert =new Alert(Alert.AlertType.WARNING,"credit should be positive so we consider it 3!");
            alert.show();
        }
        Course.addCourse(course);
        Professor professor =Professor.findProfessor(professorCourseChoiceBox.getValue().toString(),Department.getLoginDep().getName());
        professor.addCourse(course);
        CourseList.getItems().add(course.getName());
        ClearTextBox();
    }

    public void addtoProfessor(ActionEvent actionEvent) {
        Professor professor = new Professor(ProfessornameTextBox.getText());
        AcademicRank academicRank = AcademicRank.LabelValue(academic.getValue().toString());
        professor.setName(ProfessornameTextBox.getText());
        Department department = Department.getDepartment(Department.getLoginDep().getName());
        department.addproftoDep(professor.getName());
        professor.setDepartment(Department.getLoginDep());
        professor.setBirthDate(profBirth.getValue());
        professor.setRank(academicRank);
        Professor.addProfessor(professor);
        professorCourseChoiceBox.getItems().add(professor.getName());
        ProfList.getItems().add(professor.getName());
        ClearTextBox();
    }
}
