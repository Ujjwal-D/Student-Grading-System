/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.gradesystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Ujjwal Dhakal (12222900)
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

    /**
     * The following tests are for averageMark() method in 
     * com.mycompany.gradesystem.GradeAnalyser.java
     * 
     */
    
    @Test
    public void averageMarkNormalCaseTest() {
        Student[] sdata = {
            new Student("S210", "Jeremy", "Walsh", 10, 20, 30, "P"), // 60
            new Student("S520", "Betty", "Coombs", 20, 30, 40, "C")   // 90
        };
        GradeAnalyser ga = new GradeAnalyser(sdata);
        double result = ga.averageMark();
        assertEquals(75.0, result, 0.01);
    }

    @Test
    public void averageMarkWithNegativeMarksTest() {
        Student[] sdata = {
            new Student("S210", "Jeremy", "Walsh", -5, 10, 15, "F"), // 20
            new Student("S520", "Betty", "Coombs", 5, 5, 5, "F")     // 15
        };
        GradeAnalyser ga = new GradeAnalyser(sdata);
        double result = ga.averageMark();
        assertEquals(17.5, result, 0.01);
    }

    @Test
    public void averageMarkEmptyDataTest() {
        Student[] sdata = {};
        GradeAnalyser ga = new GradeAnalyser(sdata);
        assertThrows(EmptyListException.class, () -> ga.averageMark());
    }

    /**
     * The following tests are for  maximum()
     * method in com.mycompany.gradesystem.GradeAnalyser.java
     * 
     */
    
    @Test
    public void maximumNormalCaseTest() {
        Student[] sdata = {
            new Student("S1", "A", "B", 15, 15, 15, "C"),  // 45
            new Student("S2", "C", "D", 25, 25, 25, "D")   // 75
        };
        GradeAnalyser ga = new GradeAnalyser(sdata);
        int result = ga.maximum();
        assertEquals(75, result);
    }

    @Test
    public void maximumWithNegativeMarksTest() {
        Student[] sdata = {
            new Student("S1", "A", "B", -10, -10, -10, "F"),  // -30
            new Student("S2", "C", "D", -5, -5, -5, "F")      // -15
        };
        GradeAnalyser ga = new GradeAnalyser(sdata);
        int result = ga.maximum();
        assertEquals(-15, result);
    }

    @Test
    public void maximumEmptyDataTest() {
        Student[] sdata = {};
        GradeAnalyser ga = new GradeAnalyser(sdata);
        assertThrows(EmptyListException.class, () -> ga.maximum());
    }

    
    /**
     * The following tests are for minimum() method in 
     * com.mycompany.gradesystem.GradeAnalyser.java
     * 
     */
    
    @Test
    public void minimumNormalCaseTest() {
        Student[] sdata = {
            new Student("S1", "A", "B", 15, 25, 35, "C"),  // 75
            new Student("S2", "C", "D", 5, 10, 10, "F")    // 25
        };
        GradeAnalyser ga = new GradeAnalyser(sdata);
        int result = ga.minimum();
        assertEquals(25, result);
    }

    @Test
    public void minimumWithNegativeMarksTest() {
        Student[] sdata = {
            new Student("S1", "A", "B", -20, 0, 0, "F"),     // -20
            new Student("S2", "C", "D", -5, -5, -5, "F")     // -15
        };
        GradeAnalyser ga = new GradeAnalyser(sdata);
        int result = ga.minimum();
        assertEquals(-20, result);
    }

    @Test
    public void minimumEmptyDataTest() {
        Student[] sdata = {};
        GradeAnalyser ga = new GradeAnalyser(sdata);
        assertThrows(EmptyListException.class, () -> ga.minimum());
    }

    
    /**
     * The following tests are for medianMark() 
     * method in com.mycompany.gradesystem.GradeAnalyser.java
     * 
     */

    @Test
    public void medianMarkOddCountTest() {
        Student[] sdata = {
            new Student("S210", "Jeremy", "Walsh", 8, 20, 17, "SA"),
            new Student("S520", "Betty", "Coombs", 20, 25, 30, "D"),
            new Student("S600", "Cossie", "Doyle", 20, 30, 40, "HD")
        };
        GradeAnalyser ga = new GradeAnalyser(sdata);
        double result = ga.medianMark();
        assertEquals(75.0, result, 0.01); // median of 45, 75, 90
    }
    
    @Test
    public void medianMarkEvenCountTest() {
        Student[] sdata = {
            new Student("S210", "Jeremy", "Walsh", 15, 15, 15, "F"),
            new Student("S520", "Betty", "Coombs", 18, 20, 22, "P"),
            new Student("S600", "Cossie", "Doyle", 20, 25, 35, "D"),
            new Student("S880", "Liam", "Scott", 20, 30, 40, "HD")
        };
        GradeAnalyser ga = new GradeAnalyser(sdata);
        double result = ga.medianMark();
        assertEquals(70.0, result, 0.01); // median of 60 and 85
    }
    
    @Test
    public void medianMarkSameValuesTest() {
        Student[] sdata = {
            new Student("S210", "Jeremy", "Walsh", 18, 18, 18, "P"),
            new Student("S520", "Betty", "Coombs", 18, 18, 18, "P"),
            new Student("S600", "Cossie", "Doyle", 18, 18, 18, "P")
        };
        GradeAnalyser ga = new GradeAnalyser(sdata);
        double result = ga.medianMark();
        assertEquals(54.0, result, 0.01);
    }

    @Test
    public void medianMarkEmptyDataTest() {
        Student[] sdata = {};
        GradeAnalyser ga = new GradeAnalyser(sdata);
        assertThrows(EmptyListException.class, () -> ga.medianMark());
    }
    
}
