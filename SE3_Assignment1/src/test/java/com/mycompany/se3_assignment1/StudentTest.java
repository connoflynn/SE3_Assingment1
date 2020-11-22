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
        Student student = new Student("Conn", 24, "21/06/1996", 15445178);
        
        //Test getUsername1
        System.out.println("getUsername");
        Student instance = student;
        String expResult = "Conn_24";
        String result = instance.getUsername("Conn", 24);
        assertEquals(expResult, result);
        
        //Test getUsername2
        System.out.println("getUsername2");
        expResult = "Conn_24";
        result = student.getUsername();
        assertEquals(expResult, result); 
        
        //Test setCourse
        System.out.println("setCourse");
        Course comp = new Course("Computer Science");
        student.setCourse(comp);
        assertEquals(comp, student.getCourse());
        
        //Test removeCourse
        System.out.println("removeCourse");
        student.removeCourse(comp);
        assertNull(student.getCourse());

        //Test setModule
        System.out.println("setModule");
        ArrayList<Module> modules =  new ArrayList<Module>();
        modules.add(new Module("Software Engineering", "SE101"));
        modules.add(new Module("Programming", "P101"));
        student.setModules(modules);
        assertEquals(modules, student.getModules());
        
        //Test addModule
        System.out.println("addModule");
        Module algorithms = new Module("Algorithms", "A101");
        student.addModule(algorithms);
        assert(student.getModules().contains(algorithms));
        
        
        //Test removeModule
        System.out.println("removeModule");
        student.removeModule(algorithms);
        assert(!student.getModules().contains(algorithms));
        
    }
    
}
