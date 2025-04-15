/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.gradesystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This test file contains test methods of com.mycompany.gradesystem.DataSet.java
 * 
 * @author Ujjwal Dhakal (12222900)
 */
public class DataSetTest {
    
    public DataSetTest() {
        
    }
    
    /**
     * Golden Path tests
     * 
     * This test set contains random tests with normal inputs.
     */
    
    // testing for normal three elements in student array.
    @Test
    public void getDataThreeElementsTest() {
        String[][] studentDetails = {
            {"S40", "David", "White"},
            {"S50", "Eli", "Jen"},
            {"S65", "Jimmy", "Donaldson"}
        };

        int[][] studentMarks = {
            {12, 9, 24},
            {20, 28, 44},
            {5, 16, 25}
        };

        Student[] expected = {
            new Student("S50", "Eli", "Jen", 20, 28, 44, "HD"),
            new Student("S65", "Jimmy", "Donaldson", 5, 16, 25, "SA"),
            new Student("S40", "David", "White", 12, 9, 24, "F")
        };

        DataSet ds = new DataSet(studentDetails, studentMarks);
        assertArrayEquals(expected, ds.getData());
    }
    
    /**
     * Edge cases test
     * 
     * This test set contains tests with empty arrays and single student array.
     */
    
    // testing for empty array.
    @Test
    public void getDataEmptyInputTest() {
        String[][] studentDetails = {};
        int[][] studentMarks = {};

        DataSet ds = new DataSet(studentDetails, studentMarks);
        Student[] expected = {};

        assertArrayEquals(expected, ds.getData());
    }
    
    // testing for single student array.
    @Test
    public void getDataSingleStudentTest() {
        String[][] studentDetails = {
            {"S35", "Ali", "G"}
        };

        int[][] studentMarks = {
            {20, 30, 50}
        };

        Student[] expected = {
            new Student("S35", "Ali", "G", 20, 30, 50, "HD")
        };

        DataSet ds = new DataSet(studentDetails, studentMarks);
        assertArrayEquals(expected, ds.getData());
    }
    
    // testing for already sorted hardcoded array.
    @Test
    public void getDataAlreadySortedTest() {
        String[][] studentDetails = {
            {"S01", "Topper", "Student"},
            {"S02", "Middle", "Student"},
            {"S03", "Low", "Student"}
        };

        int[][] studentMarks = {
            {20, 30, 50}, // 100 - HD
            {15, 20, 30}, // 65 - C
            {5, 5, 10}    // 20 - F
        };

        Student[] expected = {
            new Student("S01", "Topper", "Student", 20, 30, 50, "HD"),
            new Student("S02", "Middle", "Student", 15, 20, 30, "C"),
            new Student("S03", "Low", "Student", 5, 5, 10, "F")
        };

        DataSet ds = new DataSet(studentDetails, studentMarks);
        assertArrayEquals(expected, ds.getData());
    }

    
    /**
     * Special Test Cases
     * 
     * This test set contains absent fail conditions and supplementary eligibility conditions.
     */
    
    // testing for zero marks in all assessments
    @Test
    public void getDataAbsentFailTest() {
        String[][] studentDetails = {
            {"S111", "Beetle", "Juice"}
        };

        int[][] studentMarks = {
            {0, 0, 0}
        };

        Student[] expected = {
            new Student("S111", "Beetle", "Juice", 0, 0, 0, "AF")
        };

        DataSet ds = new DataSet(studentDetails, studentMarks);
        assertArrayEquals(expected, ds.getData());
    }

    // testing for eligbility of supplementary 
    @Test
    public void getDataSupplementaryAssessmentTest() {
        String[][] studentDetails = {
            {"S21", "Holy", "Moly"}
        };

        int[][] studentMarks = {
            {10, 15, 20} // total = 45; 1 failed assessment
        };

        Student[] expected = {
            new Student("S21", "Holy", "Moly", 10, 15, 20, "SA")
        };

        DataSet ds = new DataSet(studentDetails, studentMarks);
        assertArrayEquals(expected, ds.getData());
    }


}
