/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.gradesystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Ujjwal
 */
public class GradeAnalyserTest {
    
    public GradeAnalyserTest() {
    }
    
    /**
     * Unit tests for find() method in com.mycompany.gradesystem.GradeAnalyser.java
     * 
     * Normal Happy path test
     * 
     */
    
    // tests find method with a valid id.
    @Test
    public void findWhenFoundTest() {
       //raw data
        Student[] sdata = {
            new Student("S210", "Jeremy", "Walsh", 15, 28, 49,  "HD"),
            new Student("S520", "Betty", "Coombs", 5, 16, 25,  "SA"),
            new Student("S600", "Cossie", "Doyle", 12, 9, 24,  "F")
        };
        String id = "S210";
        GradeAnalyser ga = new GradeAnalyser(sdata);
        Student expResult = new Student("S210", "Jeremy", "Walsh", 15, 28, 49,  "HD"); // Object of Student
        Student result = ga.find(id);
        assertEquals(expResult, result); 
    }
    
    // tests find method with invalid id.
    @Test
    public void findWhenNotFoundTest() {
        Student[] sdata = {
            new Student("S210", "Jeremy", "Walsh", 15, 28, 49, "HD"),
            new Student("S520", "Betty", "Coombs", 5, 16, 25, "SA"),
            new Student("S600", "Cossie", "Doyle", 12, 9, 24, "F")
        };
        String id = "S999"; // Not in data
        GradeAnalyser ga = new GradeAnalyser(sdata);
        Student result = ga.find(id);
        assertNull(result);
    }
    
    /**
     * Edge Case Tests for find() method
     * 
     */
    
    // tests find method with empty array 
    @Test
    public void findWhenEmptyDataTest() {
        Student[] sdata = {};
        String id = "S210";
        GradeAnalyser ga = new GradeAnalyser(sdata);
        Student result = ga.find(id);
        assertNull(result);
    }

    // tests find method with null id.
    @Test
    public void findWithNullIdTest() {
        Student[] sdata = {
            new Student("S210", "Jeremy", "Walsh", 15, 28, 49, "HD")
        };
        String id = null;   // provide null id.
        GradeAnalyser ga = new GradeAnalyser(sdata);
        Student result = ga.find(id);
        assertEquals(id, result);
    }
    
    /**
     * Special Edge Case test for find() method.
     * 
     */
    
    // test find method with valid student id in lowercase
    @Test
    public void findWithIncorrectCaseIdTest() {
        Student[] sdata = {
            new Student("S210", "Jeremy", "Walsh", 15, 28, 49, "HD")
        };
        String id = "s210"; // provide valid id in lowercase.
        GradeAnalyser ga = new GradeAnalyser(sdata);
        Student result = ga.find(id);
        assertNull(result);
    }



    
}
