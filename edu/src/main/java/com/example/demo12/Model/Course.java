package com.example.demo12.Model;

import java.util.ArrayList;
import java.util.Objects;

public class Course {
    private String name;
    private int credits = 3;
    Department department;
    public static ArrayList<Course> courses = new ArrayList<>();
    Professor professor;

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Course(String name) {
        this.name = name;
    }

    public static void addCourse(Course course) {
        courses.add(course);
    }


    public static ArrayList<Course> getCourses() {
        return courses;
    }

    public static Course getCourseByName(String courseName) {
        for (Course course : courses) {
            if (course.getName().equals(courseName)) {
                return course;
            }
        }
        return null;
    }

    public static Course getCourse(String name) {
        for (Course course : courses) {
            if (course.getName().equals(name)) {
                return course;
            }
        }
        return null;
    }


    public void setCredits(int credits) {
        if(credits > 0 && credits <= 6) {
            this.credits = credits;
        }
    }

    public int getCredits() {
        return credits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return credits == course.credits && Objects.equals(name, course.name) && Objects.equals(department, course.department);
    }

    @Override
    public String toString() {
        return "Course : " +
                "name= " + name +",  "+
                "credits= " + credits +",  "+
                "professor= "+professor.getName()+",  "+
                "department= " + department.getName()
                ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
