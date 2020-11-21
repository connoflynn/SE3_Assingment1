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
public class StudentTest {
    public StudentTest() {
    }
    
    
    @Test
    public void testStudent(){
        ArrayList<Course> courses = new ArrayList<Course>();
        ArrayList<Module> modules = new ArrayList<Module>();
        Student student = new Student("Conn", 24, "21/06/1996", 15445178, courses, modules);
        
        //Test getUsername1
        System.out.println("getUsername");
        Student instance = student;
        String expResult = "Conn_24";
        String result = instance.getUsername("Conn", 24);
        assertEquals(expResult, result);
        
        //Test getUsername2
        System.out.println("getUsername");
        expResult = "Conn_24";
        result = student.getUsername();
        assertEquals(expResult, result); 
    }
    
}
