/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.se3_assignment1;

import java.util.ArrayList;
import org.joda.time.DateTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Conn O'Flynn
 */
public class CourseTest {
    
    public CourseTest() {
    }

    @Test
    public void testCourse(){
        Course computerScience = new Course("Computer Science");
        
        //Test setModules
        System.out.println("setModules");
        ArrayList<Module> modules =  new ArrayList<Module>();
        modules.add(new Module("Software Engineering", "SE101"));
        modules.add(new Module("Programming", "P101"));
        computerScience.setModules(modules);
        assertEquals(modules, computerScience.getModules());
        
        //Test setStudents
        System.out.println("setStudents");
        ArrayList<Student> students =  new ArrayList<Student>();
        students.add(new Student("Conn", 24, "21/06/1996", 15445178));
        students.add(new Student("Bob", 23, "18/03/1997", 16778321));
        computerScience.setStudents(students);
        assertEquals(students, computerScience.getStudents());
        
        //Test addModule
        System.out.println("addModule");
        Module algorithms = new Module("Algorithms", "A101");
        computerScience.addModule(algorithms);
        assert(computerScience.getModules().contains(algorithms));
        
        
        //Test removeModule
        System.out.println("removeModule");
        computerScience.removeModule(algorithms);
        assert(!computerScience.getModules().contains(algorithms));
        
        //Test addStudent
        System.out.println("addStudent");
        Student student = new Student("Joe", 24, "06/07/1996", 15639473);
        computerScience.addStudent(student);
        assert(computerScience.getStudents().contains(student));
        
        
        //Test removeStudent
        System.out.println("removeStudent");
        computerScience.removeStudent(student);
        assert(!computerScience.getStudents().contains(student));
    }
    
}
