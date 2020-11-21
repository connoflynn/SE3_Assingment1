package com.mycompany.se3_assignment1;

import java.util.ArrayList;
import org.joda.time.DateTime;

/**
 *
 * @author Conn O'Flynn
 */
public class Course {
    private String name;
    private ArrayList<Module> modules = new ArrayList<Module>();
    private ArrayList<Student> students = new ArrayList<Student>();
    private DateTime startDate;
    private DateTime endDate;

    public Course(String name){
        this.name = name;
    }
    
    public Course(String name, ArrayList<Module> modules, ArrayList<Student> students, DateTime startDate, DateTime endDate) {
        this.name = name;
        this.modules = modules;
        this.students = students;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        for (int i=0; i < modules.size(); i++){
            if(!this.modules.contains(modules.get(i))){
                this.modules.add(modules.get(i));
                modules.get(i).addCourse(this);
            }
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        for (int i=0; i < students.size(); i++){
            if(!this.students.contains(students.get(i))){
                this.students.add(students.get(i));
                students.get(i).setCourse(this);
            }
        }
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public DateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(DateTime endDate) {
        this.endDate = endDate;
    }
    
    public void addModule(Module module){
        if(!this.modules.contains(module)){
            this.modules.add(module);
            module.addCourse(this);
        }
    }
    
    public void removeModule(Module module){
        if(this.modules.contains(module)){
            this.modules.remove(module);
            module.removeCourse(this);
        }
    }
    
    public void addStudent(Student student){
        if(!this.students.contains(student)){
            this.students.add(student);
            student.setCourse(this);
        }
    }
    
    public void removeStudent(Student student){
        if(this.students.contains(student)){
            this.students.remove(student);
            student.removeCourse(this);
        }
    }
    
    @Override
    public String toString(){
        return this.name;
    }
    
}
