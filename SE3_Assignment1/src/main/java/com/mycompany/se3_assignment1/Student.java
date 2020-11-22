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
    private Course course = null;
    private ArrayList<Module> modules = new ArrayList<Module>();
    
    public Student(String name, int age, String dob, int ID){
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.ID = ID;
        this.username = getUsername(name, age);
    }

    public Student(String name, int age, String dob, int ID, Course course, ArrayList<Module> modules) {
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.ID = ID;
        this.course = course;
        this.modules = modules;
        this.username = getUsername(name, age);
    }
    
    
    public String getUsername(String name, int age){
        String username = name + "_" + Integer.toString(age);
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        if(this.course == null){
            this.course = course;
            course.addStudent(this);
        }
        else if(!this.course.equals(course)){
            this.course = course;
            course.addStudent(this);
        }
    }
    
    public void removeCourse(Course course){
        if(this.course == null){
            return;
        }
        if(this.course.equals(course)){
            this.course = null;
            course.removeStudent(this);
        }
    }
    
    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        if(this.modules == null){
            this.modules = modules;
            for (int i=0; i < modules.size(); i++){
                modules.get(i).addStudent(this);
            }
        }
        else{
            for (int i=0; i < modules.size(); i++){
                if(!this.modules.contains(modules.get(i))){
                    this.modules.add(modules.get(i));
                    modules.get(i).addStudent(this);
                }
            }
        }
    }
    
    public void addModule(Module module){
        if(!this.modules.contains(module)){
            modules.add(module);
            module.addStudent(this);
        }
    }
    
    public void removeModule(Module module){
        if(this.modules.contains(module)){
            modules.remove(module);
            module.removeStudent(this);
        }
    }
    
    @Override
    public String toString(){
        return this.name + " " + ID;
    }
    
}
