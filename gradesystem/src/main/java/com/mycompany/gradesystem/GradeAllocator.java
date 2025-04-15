/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gradesystem;

/**
 * This class has methods to determine the grade of a student as per their marks.and 
 * eligibility for supplementary assessment if required.
 * 
 * @author Ujjwal Dhakal (12222900)
 */

public class GradeAllocator {
    
    // info about the highest marks for each assessment
    // also helps to determine eligibility of a supplementary. 
    private final int maxAssess1 = 20;  // Full Marks of Assessment 1
    private final int maxAssess2 = 30;  // Full Marks of Assessment 2
    private final int maxAssess3 = 50;  // Full Marks of Assessment 3
    
    /**
     * this method helps to determine grade of student according to their marks
     * taken as parameters. It calculates total mark and returns respective grade.
     * 
     * @param a1Mark Assessment 1 marks, not null.
     * @param a2Mark Assessment 2 marks, not null.
     * @param a3Mark Assessment 3 marks, not null.
     * 
     * @return corresponding grade of the student 
     */
    
    public String determineGrade(int a1Mark, int a2Mark, int a3Mark)
    {
        int totalMarks = a1Mark+a2Mark+a3Mark; // calculates toatal marks of all assessments

        // Checks if marks in any assessment is greater than maximum value
        if(a1Mark > maxAssess1 || a2Mark > maxAssess2 || a3Mark > maxAssess3 || totalMarks < 0)
            return "Invalid Marks";
        // Checks if all marks are zero.
        else if(totalMarks == 0)
            return "AF";
        // Normal Grading accordingly.
        else if (totalMarks >= 85 && totalMarks <= 100)
            return "HD";
        else if (totalMarks >=75  && totalMarks <= 84)
            return "D";
        else if (totalMarks >=65  && totalMarks <= 74)
            return "C";
        else if (totalMarks >=50  && totalMarks <= 64)
            return "P";
        else if(totalMarks >= 45 && totalMarks <= 49 && supplementary(a1Mark, a2Mark, a3Mark))
            return "SA";
        else
            return "F";     // returns 'F' if its below 50 
    }
    
    /**
     * this method checks the eligibility of student to attend supplementary 
     * assessment if the condition is satisfied
     * 
     * @param a1Mark Assessment 1 marks, not null.
     * @param a2Mark Assessment 2 marks, not null.
     * @param a3Mark Assessment 3 marks, not null.
     * @return eligibility of student for supplementary assessment in Boolean
     */
    
    private boolean supplementary (int a1Mark, int a2Mark, int a3Mark)
    {
        int failcount = 0;      // counts the total no. of failed assessments.
        
        if(a1Mark < maxAssess1*0.5) failcount++;
        if(a2Mark < maxAssess2*0.5) failcount++;
        if(a3Mark < maxAssess3*0.5) failcount++;
        
        return (failcount == 1);
    }
}

