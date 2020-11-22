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
        if(this.modules == null){
            this.modules = modules;
            for (int i=0; i < modules.size(); i++){
                modules.get(i).addCourse(this);
            }
        }
        else{
            for (int i=0; i < modules.size(); i++){
                if(!this.modules.contains(modules.get(i))){
                    this.modules.add(modules.get(i));
                    modules.get(i).addCourse(this);
                }
            }
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        if(this.students == null){
            this.students = students;
            //Adds the students to the list of students in the modules asociated with the course
            for (int i=0; i < students.size(); i++){
                students.get(i).setCourse(this);
                for(int j = 0; j < this.modules.size(); j++){
                    this.modules.get(j).addStudent(students.get(i));
                }
            }
        }
        else{
            for (int i=0; i < students.size(); i++){
                if(!this.students.contains(students.get(i))){
                    this.students.add(students.get(i));
                    students.get(i).setCourse(this);
                    for(int j = 0; j < this.modules.size(); j++){
                        this.modules.get(j).addStudent(students.get(i));
                    }
                }
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
            //Adds the module to each student asociated with the course
            for(int i = 0; i < this.students.size(); i++){
                this.students.get(i).addModule(module);
            }
        }
    }
    
    public void removeModule(Module module){
        if(this.modules.contains(module)){
            this.modules.remove(module);
            module.removeCourse(this);
            //Removes the module from each student asociated with the course
            for(int i = 0; i < this.students.size(); i++){
                this.students.get(i).removeModule(module);
            }
        }
    }
    
    public void addStudent(Student student){
        if(!this.students.contains(student)){
            this.students.add(student);
            student.setCourse(this);
            //Adds the student to each module asociated with the course
            for(int i = 0; i < this.modules.size(); i++){
                this.modules.get(i).addStudent(student);
            }
        }
    }
    
    public void removeStudent(Student student){
        if(this.students.contains(student)){
            this.students.remove(student);
            student.removeCourse(this);
            // Removes the student from all modules asociated with the course
            for(int i = 0; i < this.modules.size(); i++){
                this.modules.get(i).removeStudent(student);
            }
        }
    }
    
    @Override
    public String toString(){
        String output = "";
        output += "\nCourse:\n";
        output += "Name: " + this.name + "\n";
        output += "Start Date: " + this.startDate.toString("dd/MM/yyyy") + "\n";
        output += "End Date: " + this.endDate.toString("dd/MM/yyyy") + "\n";
        output += "Modules: \n";
        for(int i=0; i < modules.size(); i++){
            output += modules.get(i).toString() + "\n";
        }
        output += "Students Enrolled: \n";
        for(int i=0; i < students.size(); i++){
            output += students.get(i).toString() + "\n";
        }
        output += "\n\n";
        return output;
    }
    
}
