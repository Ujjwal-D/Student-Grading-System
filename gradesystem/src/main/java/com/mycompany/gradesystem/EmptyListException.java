/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gradesystem;

/**
 * This class handles all the exceptions related to empty list and gets triggered 
 * with statistics methods in GradeAnalyser.java
 *
 * @author Ujjwal Dhakal (12222900)
 */

public class EmptyListException extends RuntimeException {
    public EmptyListException(String message)
    {
        super(message);
    }
    
}
