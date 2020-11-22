package com.mycompany.se3_assignment1;

import java.util.ArrayList;
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
public class ModuleTest {
    
    public ModuleTest() {
    }
    
    @Test
    public void testModule(){
        Module softwareEngineering = new Module("Software Engineering", "SE101");
        
        //Test setCourses
        System.out.println("setCourses");
        ArrayList<Course> courses =  new ArrayList<>();
        courses.add(new Course("Software Engineering"));
        courses.add(new Course("Programming"));
        softwareEngineering.setCourses(courses);
        assertEquals(courses, softwareEngineering.getCourses());
        
        //Test setStudents
        System.out.println("setStudents");
        ArrayList<Student> students =  new ArrayList<>();
        students.add(new Student("Conn", 24, "21/06/1996", 15445178));
        students.add(new Student("Bob", 23, "18/03/1997", 16778321));
        softwareEngineering.setStudents(students);
        assertEquals(students, softwareEngineering.getStudents());
        
        //Test addCourse
        System.out.println("addCourse");
        Course engineering = new Course("Electrical Engineering");
        softwareEngineering.addCourse(engineering);
        assert(softwareEngineering.getCourses().contains(engineering));
        
        //Test removeCourse
        System.out.println("removeCourse");
        softwareEngineering.removeCourse(engineering);
        assert(!softwareEngineering.getCourses().contains(engineering));
        
        //Test addStudent
        System.out.println("addStudent");
        Student student = new Student("Joe", 24, "06/07/1996", 15639473);
        softwareEngineering.addStudent(student);
        assert(softwareEngineering.getStudents().contains(student));
                
        //Test removeStudent
        System.out.println("removeStudent");
        softwareEngineering.removeStudent(student);
        assert(!softwareEngineering.getStudents().contains(student));
    }
    
}
