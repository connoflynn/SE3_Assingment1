package com.mycompany.se3_assignment1;

import java.util.ArrayList;

/**
 *
 * @author Conn O'Flynn
 */
public class Student {
    private String name;
    private int age;
    private String dob;
    private int ID;
    private String username;
    private ArrayList<Course> courses;
    private ArrayList<Module> modules;

    public Student(String name, int age, String dob, int ID, ArrayList<Course> courses, ArrayList<Module> modules) {
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.ID = ID;
        this.courses = courses;
        this.modules = modules;
        this.username = getUsername(name, age);
    }
    
    
    public String getUsername(String name, int age){
        String username = name + "_" + Integer.toString(age);
        System.out.println(username);
        return username;        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }
    
    public void addModule(Module module){
        modules.add(module);
    }
    
    public void removeModule(Module module){
        modules.remove(module);
    }
    
}
