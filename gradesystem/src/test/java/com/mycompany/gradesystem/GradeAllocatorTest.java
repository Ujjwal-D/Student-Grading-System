/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.gradesystem;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This test class tests methods in com.mycompany.gradesystem.GradeAllocator.java class
 * The test set includes happy path tests, edge cases, special cases 
 * as well as error conditions
 * 
 * @author Ujjwal Dhakal (12222900)
 */
public class GradeAllocatorTest {
    
    public GradeAllocatorTest() {
    }
    
    /**
     * Edge Cases Tests
     * tests for boundary values, upper and lower limits
     * 
     */
    
    // testing for upper limit of "HD" grade
    @Test
    public void upperhighDistinctionDetermineGradeTest()
    {
        int a1 = 20;
        int a2 = 30;
        int a3 = 50;    // total = 100
        GradeAllocator ga = new GradeAllocator();
        assertEquals("HD", ga.determineGrade(a1, a2, a3));
    }
    
    // testing for lower limit of "HD" grade
    @Test
    public void lowerhighDistinctionDetermineGradeTest()
    {
        int a1 = 5;
        int a2 = 30;
        int a3 = 50;    // total = 85
        GradeAllocator ga = new GradeAllocator();
        assertEquals("HD", ga.determineGrade(a1, a2, a3));
    }
    
    // testing for upper limit of "D" grade
    @Test
    public void upperdistinctionDetermineGradeTest()
    {
        int a1 = 20;
        int a2 = 14;
        int a3 = 50;    // total 84
        GradeAllocator ga = new GradeAllocator();
        assertEquals("D", ga.determineGrade(a1, a2, a3));
    }

    // testing for lower limit of "D" grade
    @Test
    public void lowerdistinctionDetermineGradeTest()
    {
        int a1 = 20;
        int a2 = 30;
        int a3 = 25;    // total 75
        GradeAllocator ga = new GradeAllocator();
        assertEquals("D", ga.determineGrade(a1, a2, a3));
    }
    
    // testing for upper limit of "C" grade
    @Test
    public void uppercreditDetermineGradeTest()
    {
        int a1 = 20;
        int a2 = 24;
        int a3 = 30;    // total 74
        GradeAllocator ga = new GradeAllocator();
        assertEquals("C", ga.determineGrade(a1, a2, a3));
    }
    
    // testing for lower limit of "C" grade
    @Test
    public void lowercreditDetermineGradeTest()
    {
        int a1 = 10;
        int a2 = 25;
        int a3 = 30;    // total 65
        GradeAllocator ga = new GradeAllocator();
        assertEquals("C", ga.determineGrade(a1, a2, a3));
    }
    
    // testing for upper limit of  "P" grade
    @Test
    public void upperpassDetermineGradeTest()
    {
        int a1 = 20;
        int a2 = 24;
        int a3 = 20;    // total 64
        GradeAllocator ga = new GradeAllocator();
        assertEquals("P", ga.determineGrade(a1, a2, a3));
    }
    
    // testing for lower limit of  "P" grade
    @Test
    public void lowerpassDetermineGradeTest()
    {
        int a1 = 20;
        int a2 = 0;
        int a3 = 30;    // total 50
        GradeAllocator ga = new GradeAllocator();
        assertEquals("P", ga.determineGrade(a1, a2, a3));
    }
    
    // testing for upper limit of "SA" eligibility
    @Test
    public void uppersupplementaryDetermineGradeTest()
    {
        int a1 = 9;
        int a2 = 15;
        int a3 = 25;    // total = 49
        GradeAllocator ga = new GradeAllocator();
        assertEquals("SA", ga.determineGrade(a1, a2, a3));
    }
    
    // testing for lower limit of "SA" eligibility
    @Test
    public void lowersupplementaryDetermineGradeTest()
    {
        int a1 = 10;
        int a2 = 10;
        int a3 = 25;    // total = 45
        GradeAllocator ga = new GradeAllocator();
        assertEquals("SA", ga.determineGrade(a1, a2, a3));
    }
    
    // testing for upper limit of "F" grade
    @Test
    public void upperfailDetermineGradeTest()
    {
        int a1 = 9;
        int a2 = 14;
        int a3 = 26;    // total = 49
        GradeAllocator ga = new GradeAllocator();
        assertEquals("F", ga.determineGrade(a1, a2, a3));
    }
    
    // testing for lower limit of "F" grade
    @Test
    public void lowerfailDetermineGradeTest()
    {
        int a1 = 0;
        int a2 = 0;
        int a3 = 1;    // total = 1
        GradeAllocator ga = new GradeAllocator();
        assertEquals("F", ga.determineGrade(a1, a2, a3));
    }
    

    /**
     * Error Conditions Test
     * This test set includes test involving marks higher than maximum value or
     * negative value
     * 
     */
    
    // testing with higher marks for Assessment 1 (max = 20)
    @Test
    public void invalidAss1DetermineGradeTest() {
        int a1 = 21, a2 = 30, a3 = 50; // a1 > max
        GradeAllocator ga = new GradeAllocator();
        assertEquals("Invalid Marks", ga.determineGrade(a1, a2, a3));
    }
    
    // testing with higher marks for Assessment 2 (max = 30)
    @Test
    public void invalidAss2DetermineGradeTest() {
        int a1 = 20, a2 = 31, a3 = 50; // a2 > max
        GradeAllocator ga = new GradeAllocator();
        assertEquals("Invalid Marks", ga.determineGrade(a1, a2, a3));
    }

    // testing with higher marks for Assessment 3 (max = 50)
    @Test
    public void invalidAss3DetermineGradeTest() {
        int a1 = 20, a2 = 30, a3 = 51; // a3 > max
        GradeAllocator ga = new GradeAllocator();
        assertEquals("Invalid Marks", ga.determineGrade(a1, a2, a3));
    }
    
    // testing with higher marks for all assessments
    @Test
    public void invalidAllAssessmentsDetermineGradeTest() {
        int a1 = 21, a2 = 31, a3 = 51; // all > max
        GradeAllocator ga = new GradeAllocator();
        assertEquals("Invalid Marks", ga.determineGrade(a1, a2, a3));
    }
    
    /**
     * Special Cases Test
     * This test set includes test related to "AF" and false "SA" grade
     * 
     */
    
    // testing for "AF" grade
    @Test
    public void absentFailDetermineGradeTest()
    {
        int a1 = 0;
        int a2 = 0;
        int a3 = 0; // total = 0
        GradeAllocator ga = new GradeAllocator();
        assertEquals("AF", ga.determineGrade(a1, a2, a3));
    }
    
    // testing for uneligible "SA" grade or "F" grade 
    @Test
    public void uneligibleSupplementaryDetermineGradeTest()
    {
        int a1 = 9;
        int a2 = 10;
        int a3 = 26; // total = 45, failed 2 assessments
        GradeAllocator ga = new GradeAllocator();
        assertEquals("F", ga.determineGrade(a1, a2, a3));
    }
}
