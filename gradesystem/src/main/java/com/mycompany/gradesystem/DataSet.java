/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gradesystem;

/**
 * This class has the methods to load the student data into an array, sorts them
 * in descending order according to their total marks and make it ready to use with getter.
 * 
 * 
 * @author Ujjwal Dhakal (12222900)
 */
public class DataSet {
    
    private GradeAllocator grader;             // Used to determine grades
    private Student[] students;                // Array of Student records/objects

    // Hardcoded raw student data
    private final String[][] studentDetails = { // Each row = [id, name, age, etc.]
        {"S101", "Mark", "Jonas"},
        {"S120", "James", "Cullen"},
        {"S157", "Betty", "Allen"}
    };
    
    // Hardcoded raw student marks
    private final int[][] studentMarks = {  // Each row = [a1, a2, a3 marks]
        {14, 21, 30},
        {9, 15, 25},
        {20, 23, 47}
    };            
    
    // This is a no-argument constructor. It triggers loading of data and sorting
    // them in descending order as per their total marks.
    
    public DataSet()
    {
        grader = new GradeAllocator(); // new object of GradeAllocator
        students = loadFromTables(studentDetails, studentMarks); // load hardcoded data
        sortByTotalMark(); // Sort the data according to total mark
    }
    
    /**
     * This constructor also triggers loading of data and sorting them 
     * 
     * @param details Array with student details (id, first name, last name), not null
     * @param marks Array with student marks (a1, a2, a3), not null
     */
    
    public DataSet(String[][] details, int[][] marks)
    {
        grader = new GradeAllocator(); // new object of GradeAllocator
        students = loadFromTables(details, marks); // load the received parameters
        sortByTotalMark(); // Sort the data according to total mark        
    }
    
    // getter method for the sorted array.
    public Student[] getData()
    {
        return students;    // returns the sorted array of students in descending order according to their marks.
    }
    
    /**
     * This method loads the hard coded student details and marks to a working student 
     * object. It also triggers GradeAllocator object to get the allocated grade
     * and makes it ready to further sort the working array in descending order.
     * 
     * @param details Array with student details (id, first name, last name), not null
     * @param marks Array with student marks (a1, a2, a3), not null
     * @return 
     */
    private Student[] loadFromTables(String[][] details, int[][] marks)
    {
        int n = details.length; // counts number of students
        Student[] studentGrades = new Student[n];   // object creation 
        
        // the loop will load the hardcoded student data to new object 
        for (int i=0; i<n; i++)
        {
            int m1 = marks[i][0];   // loading marks of assessment 1
            int m2 = marks[i][1];   // loading marks of assessment 2
            int m3 = marks[i][2];   // loading marks of assessment 3
            
            String g = grader.determineGrade(m1, m2, m3); // Determination of grade
            Student r = new Student (details[i][0], details[i][1],      
                    details[i][2], m1, m2, m3, g);  // creating new object of Student
            studentGrades[i] = r;   // assigning the array to working array
        }
        return studentGrades;   // loaded working student array
    }
    
    // This method sorts the working student array in descending order according 
    // to their total marks. Uses selection sort method to sort.
    private void sortByTotalMark() {
        
        if (students == null || students.length == 0) return;   // stops sorting if no data found.
        
        // loop starting with student at index 0 to n - 2
        for (int i = 0; i < students.length - 1; i++) {
            int maxIndex = i;
            
            //this loop will find index of student with highest total marks.
            for (int j = i + 1; j < students.length; j++) {
                int totalJ = students[j].a1() + students[j].a2() + students[j].a3(); // Sums all the marks of student at current index
                int totalMax = students[maxIndex].a1() + students[maxIndex].a2() + students[maxIndex].a3(); // sums all the marks of student at highest index

                if (totalJ > totalMax) {
                    maxIndex = j;   // Swap the index if the total mark of current index is higher
                }
            }

            // Swap the student at index i with maxindex. Here the actual sort happens before another loop
            Student temp = students[i]; // stores previous student array in temporary container
            students[i] = students[maxIndex];   // replaces with new highest array on that index. 
            students[maxIndex] = temp;  // stores previous highest array to maxIndex for futher comparison.
        }
    }
}
