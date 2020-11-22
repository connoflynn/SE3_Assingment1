package com.mycompany.se3_assignment1;

import java.util.ArrayList;

/**
 *
 * @author Conn O'Flynn
 */
public class Module {
    private String name;
    private String module_id;
    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<Course> courses = new ArrayList<Course>();

    public Module(String name, String module_id){
        this.name = name;
        this.module_id = module_id;
    }
    
    public Module(String name, String module_id, ArrayList<Student> students, ArrayList<Course> courses) {
        this.name = name;
        this.module_id = module_id;
        this.students = students;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModule_id() {
        return module_id;
    }

    public void setModule_id(String module_id) {
        this.module_id = module_id;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        if(this.students == null){
            this.students = students;
            for (int i=0; i < courses.size(); i++){
                students.get(i).addModule(this);
            }
        }
        else{
            for (int i=0; i < students.size(); i++){
                if(!this.students.contains(students.get(i))){
                    this.students.add(students.get(i));
                    students.get(i).addModule(this);
                }
            }
        }
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        if(this.courses == null){
            this.courses = courses;
            for (int i=0; i < courses.size(); i++){
                courses.get(i).addModule(this);
            }
        }
        else{
            for (int i=0; i < courses.size(); i++){
                if(!this.courses.contains(courses.get(i))){
                    this.courses.add(courses.get(i));
                    courses.get(i).addModule(this);
                }
            }
        }
    }
    
    public void addStudent(Student student){
        if(!this.students.contains(student)){
            students.add(student);
            student.addModule(this);
        }
    }
    
    public void removeStudent(Student student){
        if(this.students.contains(student)){
            students.remove(student);
            student.removeModule(this);
        }
    }
    
    public void addCourse(Course course){
        if(!this.courses.contains(course)){
            courses.add(course);
            course.addModule(this);
        }
    }
    
    public void removeCourse(Course course){
        if(this.courses.contains(course)){
            courses.remove(course);
            course.removeModule(this);
        }
    }

    @Override
    public String toString(){
        return this.name;
    }
    
}
