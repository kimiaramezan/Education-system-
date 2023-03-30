package com.example.demo12.Model;

public class GradeReport {
    Course course;
    Student student;
    double grade;

    public Course getCourse() {
        return course;
    }

    public GradeReport(Course course, Student student, double grade) {
        this.course = course;
        this.grade = grade;
        this.student = student;
    }

    public GradeReport(Course course, Student student) {
        this.course = course;
        this.student = student;
        grade = -1;
    }

    public static GradeReport findGrade(Course course, Student student) {
        for (int i=0;i<student.getGrades().size();i++){
            if(student.getGrades().get(i).getCourse().equals(course)){
                System.out.println(student.getGrades().get(i));
                return student.getGrades().get(i);
            }
        }
        return null;
    }

//    @Override
//    public String toString() {
//        return "grade=" + grade ;
//    }

    @Override
    public String toString() {
        return "course=" + course.getName()+
                ", grade=" + grade ;
    }
}
