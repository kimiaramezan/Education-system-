package com.example.demo12.Model;

import javafx.scene.control.Alert;

import java.time.LocalDate;
import java.util.ArrayList;

public class Student {
    public static ArrayList<Student> students = new ArrayList<>();
    public  ArrayList<Course> studentCourses = new ArrayList<>();
    private ArrayList<GradeReport> grades = new ArrayList<>();
    private String name;
    private String StudentID;
    private Department department;
    java.time.LocalDate BirthDate;
    public static Student CurrentStudent;
    public static Student LoginStudent;

    public  ArrayList<Course> getStudentCourses() {
        return studentCourses;
    }

    public void setGrades(ArrayList<GradeReport> grades) {
        this.grades = grades;
    }

    public LocalDate getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        BirthDate = birthDate;
    }

    public static Student getLoginStudent() {
        return LoginStudent;
    }

    public static void setLoginStudent(Student loginStudent) {
        LoginStudent = loginStudent;
    }

    public Student(String studentID) {
        StudentID = studentID;
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static void setStudents(ArrayList<Student> students) {
        Student.students = students;
    }

    public static void addStudent(Student student) {
        students.add(student);
    }

    public static Student getStudent(String id) {
            for (Student student : students) {
                if (student.getStudentID().equals(id)) {
                    return student;
                }
            }
        return null;
    }

    public static Student findStudent(String id, String name) {
        for (Student student : students) {
            if (student.getStudentID().equals(id) && student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }


    public ArrayList<Course> getCourses() {
        return new ArrayList<>(studentCourses);
    }

    public void setStudentCourses(ArrayList<Course> studentCourses) {
        this.studentCourses = studentCourses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    public void takeCourse(Course course){
        studentCourses.add(course);
    }
    public void settheGrades( GradeReport gradeReport){
        grades.add(gradeReport);
    }

    public ArrayList<GradeReport> getGrades() {
        return new ArrayList<>(grades);
    }


    public void finishCourse(Course course, double grade){
        GradeReport gradeReport = new GradeReport(course,this,grade);
        grades.add(gradeReport);
        studentCourses.remove(course);
    }


    @Override
    public String toString() {
        return "Student : " +
                "\nstudentCourses= " + studentCourses +
                "\ngrades= " + grades +
                "\nname= " + name +
                "\nStudentID= " + StudentID +
                "\nbirth date= "+ BirthDate
                ;
    }

//    @Override
//    public String toString() {
//        return "Name: " + name + "\n" +
//                "Student ID: " + StudentID + "\n"+
//                "Courses: " + studentCourses.toString()+ "\n";
//
//    }

    public void addCourse(Course course) {
        System.out.println("Course added");
        studentCourses.add(course);
    }

    public void remove(Student student) {
        students.remove(student);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"student is W");
    }

    public void removetheGrade(GradeReport grade, Student student) {
        grades.remove(grade);
    }
}
