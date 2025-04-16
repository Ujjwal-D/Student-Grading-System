/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gradesystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    
    /**
     * This method returns the array of ordered list.
     * 
     * @return orderedlist of student
     */
    public Student[] getOrderedList() {
        return orderedList.toArray(new Student[0]);
    }
    
    /**
     * This method calculates the average marks of the whole class.
     * 
     * @return average marks of the whole class in normal run.
     */
    public double averageMark()
    {
        int sum = 0;    // holds total marks of the class
        double average = 0; // holds average marks of the class
        
        if(orderedList.isEmpty()) 
            throw new EmptyListException("No student records found.");
        
        // calculate the sum of total marks of all students
        for(Student s : orderedList)
        {
            sum += s.total();   // adding all the totals by invoking total method.
        }
        
        // calcualte average mark of the class
        average = (double)sum / orderedList.size();  // changing int to double
        return average; 
    }
    
    /**
     * This method finds and returns the maximum marks in whole class
     * 
     * @return the maximum marks in whole class in normal run.
     */
    
    public int maximum() {
    // Throw exception if list is empty
        if (orderedList.isEmpty()) {
            throw new EmptyListException("No student records found.");
        }
        
        int max = Integer.MIN_VALUE; // choose the minimum value to start comparison

        // Find the maximum total marks
        for (Student s : orderedList) {
            int total = s.total();
            if (total > max) {
                max = total;    // updating the current maximum marks
            }
        }

        return max;
    }
    
    /**
     * This method finds and returns the minimum marks in whole class
     * 
     * @return the minimum marks in whole class in normal run.
     */
    
    public int minimum() {
        
        if (orderedList.isEmpty()) {
            throw new EmptyListException("No student records found."); // Throw exception if list is empty
        }

        // start with the highest possible value
        int min = Integer.MAX_VALUE;

        // Find the minimum total marks
        for (Student s : orderedList) {
            int total = s.total();
            if (total < min) {
                min = total;
            }
        }

        return min;
    }
    
    /**
     * This method calculates median marks in whole class
     * 
     * @return median marks of whole class in normal run
     */
    
    public double medianMark() {
        // Throw exception if list is empty
        if (orderedList.isEmpty()) {
            throw new EmptyListException("No student records found.");
        }

        
        List<Integer> marks = new ArrayList<>();    // empty list of integer.
        for (Student s : orderedList) {
            marks.add(s.total());   // Create a list of total marks
        }

        // Sort the marks in ascending order
        Collections.sort(marks);

        int size = marks.size();    // find the size of the observation
        double median;  // holds median value

        // Check if the size is even or odd 
        if (size % 2 == 0) {
            int mid1 = marks.get(size / 2 - 1);
            int mid2 = marks.get(size / 2);
            median = (mid1 + mid2) / 2.0; // calculates median
        } else {
            median = marks.get(size / 2);
        }

        return median;
    }


}
