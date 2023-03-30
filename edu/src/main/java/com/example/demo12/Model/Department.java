package com.example.demo12.Model;

import java.util.ArrayList;

public class Department extends Object{
    private String name;
    private String Id;
    private ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Department> departments = new ArrayList<>();
    private ArrayList<Professor> professors = new ArrayList<>();
    public static Department LoginDep;
    private ArrayList<String> pf =new ArrayList<>();

    public Department(String name, String id) {
        this.name = name;
        Id = id;
    }
    public static Department getLoginDep() {
        return LoginDep;
    }

    public static void setDepartments(ArrayList<Department> departments) {
        Department.departments = departments;
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }

    public static void setLoginDep(Department loginDep) {
        LoginDep = loginDep;
    }

    public Department(String name) {
        this.name = name;
    }

    public static void addDepartment(Department department) {
        departments.add(department);
    }
    public void addproftoDep(String name){this.pf.add(name);}

    public static Department findDepartment(String name) {
        for(Department department : departments)
            if(department.getName().equals(name))
                return department;
        return null;
    }

    public static Department getDepartment(String name) {
        for (Department department : departments) {
            if (department.getName().equals(name)) {
                return department;
            }
        }
        return null;
    }


    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public ArrayList<Professor> getFaculty() {
        return new ArrayList<>(professors);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return this.name.equals(that.name) && this.Id.equals(that.Id);
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public static ArrayList<Department> getDepartments() {
        return departments;
    }

    @Override
    public String toString() {
        for(Professor professor :professors){
            if(professor.getDepartment().equals(name)){
                pf.add(professor.getName());
                System.out.println("ehem");
            }
        }
        return "Department : " +
                "name= " + name +",  "+
                "Id= " + Id +",  "+
                "professors= " + pf
                ;
    }
}
