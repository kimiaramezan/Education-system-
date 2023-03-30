package com.example.demo12.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Professor {
    private String name;
    java.time.LocalDate BirthDate;
    Department department;
    AcademicRank Rank;
    public ArrayList<Course> courses = new ArrayList<>();
    public static ArrayList<Professor> professors = new ArrayList<>();
    public static Professor LoginProfessor;

    public static Professor getLoginProfessor() {
        return LoginProfessor;
    }

    public AcademicRank getRank() {
        return Rank;
    }

    public void setRank(AcademicRank rank) {
        Rank = rank;
    }

    public static void setLoginProfessor(Professor loginProfessor) {
        LoginProfessor = loginProfessor;
    }

    public Professor(String name) {
        this.name = name;

    }

    public LocalDate getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        BirthDate = birthDate;
    }

    public static void addProfessor(Professor professor) {
        professors.add(professor);
        System.out.println("added");
    }

    public static Professor getProfessor(String name) {
        for (Professor professor : professors) {
            if (professor.getName().equals(name)) {
                return professor;
            }
        }
        return null;
    }


    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public static Department getDepartmentByName(String name){
        for (Professor professor : professors) {
            if (professor.getName().equals(name)) {
                return professor.getDepartment();
            }
        }

        return null;
    }

    public static Professor findProfessor(String name, String department) {
        for (Professor professor : professors) {
           if(professor.getName().equals(name)){
               System.out.println(professor.getDepartment().getName().equals(department));
           }
                if (professor.getName().equals(name) && professor.getDepartment().getName().equals(department)) {
                    return professor;
                }
        }
        return null;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Course> getCourses() {
        return new ArrayList<>(courses);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(name, professor.name) && Objects.equals(BirthDate, professor.BirthDate) && Objects.equals(department, professor.department) && Objects.equals(Rank, professor.Rank) && Objects.equals(courses, professor.courses);
    }

    public static ArrayList<Professor> getProfessors() {
        return professors;
    }

//    @Override
//    public String toString() {
//        return name;
//    }


    @Override
    public String toString() {
        return "Professor" +
                "\nname= " + name +
                "\nBirthDate= " + BirthDate +
                "\ndepartment= " + department.getName() +
                "\nRank= " + Rank +
                "\ncourses= " + courses
                ;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

}
