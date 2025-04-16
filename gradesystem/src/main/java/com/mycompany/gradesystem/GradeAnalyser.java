/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gradesystem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Ujjwal Dhakal (12222900)
 */
public class GradeAnalyser {
    private List<Student> orderedList;
    private HashMap<String, Student> studentHashTable;
    
    /**
     * This method will have the upper and lower bound of mark range of all students.
     * 
     * @param lower Lower bound of mark range, not null
     * @param upper Upper bound of mark range, not null
     */
    
    public record Range(int lower, int upper)
    {
        
    }
    
    /**
     * This method validates the bounds of mark range
     * 
     * @param result Boolean value to specify if bounds are valid or invalid.
     * @param range Record range
     * @param message String value to give appropriate message if bounds are invalid.
     * 
     * @return if valid then returns range and if invalid returns message with explanation.
     */
    
    public record RangeValidationResponse(boolean result, Range range, String message)
    {
        
    }
    
    /**
     * This constructor helps to initialize ordered list of student data and 
     * populate Hashmap object of student data.
     * 
     * @param dataset DataSet object for initialization, not null
     * 
     */
    
    public GradeAnalyser(DataSet dataset)
    {
        Student[] students = dataset.getData();                     // Get student array
        orderedList = Arrays.asList(students);                      // Convert to List
        studentHashTable = new HashMap<>();                         // Create HashMap

        for (Student s : orderedList) {
            studentHashTable.put(s.id(), s);                        // Use ID as key 
        }
    }
    
    /**
     * This constructor is used to initialize data while testing the public 
     * methods.
     * 
     * @param studentResults Sorted array of students with correct grades
     * 
     */
    
    public GradeAnalyser(Student[] studentResults)
    {
        orderedList = Arrays.asList(studentResults);    // Converts array to List
        studentHashTable = new HashMap<>();

        for (Student s : orderedList) {     
            studentHashTable.put(s.id(), s);    //populating hash table
        }
    }
    
    /**
     * This method fetches student details if available as per their student id.
     * 
     * @param id Student id parameter, not null
     * @return student details if exist or null.
     */
    
    public Student find (String id)
    {
        return studentHashTable.get(id);    // fetches student details if exists and null if not.
    }
    
    public Student[] getOrderedList() {
        return orderedList.toArray(new Student[0]);
    }
}
