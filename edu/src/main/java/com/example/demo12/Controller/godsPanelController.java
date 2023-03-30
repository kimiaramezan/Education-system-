package com.example.demo12.Controller;

import com.example.demo12.Main;
import com.example.demo12.Model.*;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import static com.example.demo12.Model.Professor.professors;

public class godsPanelController {

    public ListView sudentsList;
    public ListView professorList;
    public ListView courseList;
    public TextField nameTextBox;
    public TextArea detailsArea;
    public TextField idTextBox;
    public TextField ProfessornameTextBox;
    public TextField CoursenameTextBox;
    public TextField ProfessorDepartmentTextBox;
    public TextField DepartmentNameTextBox;
    public TextField DepartmentIdTextBox;
    public ListView departmentList;
    public ChoiceBox ProfessorDepartmentChoiceBox;
    public TextField CourseunitTextBox;
    public ChoiceBox professorCourseChoiceBox;
    public TextField CourseDepName;
    public DatePicker profBirth;

    public DatePicker STBirth;
    public ChoiceBox academic;


    public void initialize() {
        academic.getItems().add(AcademicRank.ASSISTANT_PROFESSOR.getLable());
        academic.getItems().add(AcademicRank.ASSOCIATE_PROFESSOR.getLable());
        academic.getItems().add(AcademicRank.PROFESSOR.getLable());
        for (Department department : Department.getDepartments()) {
            ProfessorDepartmentChoiceBox.getItems().add(department.getName());
        }
        for(Professor professor : Professor.getProfessors()){
            professorCourseChoiceBox.getItems().add(professor.getName());
        }
        for (Student student : Student.getStudents()) {
            sudentsList.getItems().add(student.getStudentID());
        }
        for (Department department : Department.getDepartments()) {
            departmentList.getItems().add(department.getName());
        }
        for (Course course : Course.getCourses()) {
            courseList.getItems().add(course.getName());
        }
        for (Professor professor : Professor.getProfessors()) {
            professorList.getItems().add(professor.getName());
        }
    }

    public void addtoStudent(ActionEvent actionEvent) {
        sudentsList.getItems().add(idTextBox.getText());
        Student student = new Student(idTextBox.getText());
        student.setName(nameTextBox.getText());
        student.setBirthDate(STBirth.getValue());
        Student.addStudent(student);
        clearTextBox();
    }

    public void addtoCourse(ActionEvent actionEvent) {
        courseList.getItems().add(CoursenameTextBox.getText());
        Course course = new Course(CoursenameTextBox.getText());
        course.setName(CoursenameTextBox.getText());
        course.setCredits(Integer.parseInt(CourseunitTextBox.getText().toString()));
        course.setDepartment(Department.getDepartment(CourseDepName.getText()));
        if(Integer.parseInt(CourseunitTextBox.getText().toString())<0){
            Alert alert =new Alert(Alert.AlertType.WARNING,"credit should be positive so we consider it 3!");
            alert.show();
        }
        Professor professor =Professor.findProfessor(professorCourseChoiceBox.getValue().toString(),CourseDepName.getText());
            professor.addCourse(course);
            course.setProfessor(professor);
            Course.addCourse(course);
            clearTextBox();

    }

    public void addtoProfessor(ActionEvent actionEvent) {
        professorList.getItems().add(ProfessornameTextBox.getText());
        Professor professor = new Professor(ProfessornameTextBox.getText());
        professor.setName(ProfessornameTextBox.getText());
        AcademicRank academicRank = AcademicRank.LabelValue(academic.getValue().toString());
        Department department = Department.getDepartment(ProfessorDepartmentChoiceBox.getValue().toString());
        department.addproftoDep(professor.getName());
        professor.setDepartment(Department.findDepartment(ProfessorDepartmentChoiceBox.getValue().toString()));
        professor.setBirthDate(profBirth.getValue());
        professor.setRank(academicRank);
        Professor.addProfessor(professor);
        professorCourseChoiceBox.getItems().add(professor.getName());
        clearTextBox();
    }
    public void AddtoDepartment(ActionEvent actionEvent) {
        departmentList.getItems().add(DepartmentNameTextBox.getText());
        Department department = new Department(DepartmentNameTextBox.getText());
        department.setName(DepartmentNameTextBox.getText());
        department.setId(DepartmentIdTextBox.getText());
        Department.addDepartment(department);
        ProfessorDepartmentChoiceBox.getItems().add(department.getName());
        clearTextBox();

    }

    private void clearTextBox() {
        nameTextBox.setText("");
        idTextBox.setText("");
        ProfessornameTextBox.setText("");
        CoursenameTextBox.setText("");
        DepartmentIdTextBox.setText("");
        DepartmentNameTextBox.setText("");
        ProfessorDepartmentChoiceBox.setValue("");
        CourseunitTextBox.setText("");
        professorCourseChoiceBox.setValue("");
        CourseDepName.setText("");
        STBirth.setValue(null);
        profBirth.setValue(null);
        academic.setValue(null);
    }

    public void studentListPressed(MouseEvent mouseEvent) {
        Student.getStudent(sudentsList.getSelectionModel().getSelectedItem().toString());
        detailsArea.setText(Student.getStudent(sudentsList.getSelectionModel().getSelectedItem().toString()).toString());
        }
    public void ProfessorListPressed(MouseEvent mouseEvent) {
        System.out.println("l");
        Professor.getProfessor(professorList.getSelectionModel().getSelectedItem().toString());
        detailsArea.setText(Professor.getProfessor(professorList.getSelectionModel().getSelectedItem().toString()).toString());
    }

    public void CourseListPressed(MouseEvent mouseEvent) {
        Course.getCourse(courseList.getSelectionModel().getSelectedItem().toString());
        detailsArea.setText(Course.getCourse(courseList.getSelectionModel().getSelectedItem().toString()).toString());
    }

    public void DeprtmentListPressed(MouseEvent mouseEvent) {
        Department.getDepartment(departmentList.getSelectionModel().getSelectedItem().toString());
        detailsArea.setText(Department.getDepartment(departmentList.getSelectionModel().getSelectedItem().toString()).toString());

    }

    public void backtoMainMenu(ActionEvent actionEvent) {
        changeScenecontroller.changeMenu("main");
    }

    public void gotoSTlogin(ActionEvent actionEvent) {
        changeScenecontroller.changeMenu("studentLogin");
    }

    public void gotoPFlogin(ActionEvent actionEvent) {
        changeScenecontroller.changeMenu("ProfessorLogin");

    }

    public void gotoDOlogin(ActionEvent actionEvent) {
        changeScenecontroller.changeMenu("depOficerLogin");

    }
}
