/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.gradesystem;

import java.util.List;
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
            new Student("S1", "Al", "Bl", 15, 15, 15, "C"),  // 45
            new Student("S2", "Cl", "Dl", 25, 25, 25, "D")   // 75
        };
        GradeAnalyser ga = new GradeAnalyser(sdata);
        int result = ga.maximum();
        assertEquals(75, result);
    }

    @Test
    public void maximumWithNegativeMarksTest() {
        Student[] sdata = {
            new Student("S1", "Al", "Bl", -10, -10, -10, "F"),  // -30
            new Student("S2", "Cl", "Dl", -5, -5, -5, "F")      // -15
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
            new Student("S1", "Am", "Bm", 15, 25, 35, "D"),  // 75
            new Student("S2", "Cm", "Dm", 5, 10, 10, "F")    // 25
        };
        GradeAnalyser ga = new GradeAnalyser(sdata);
        int result = ga.minimum();
        assertEquals(25, result);
    }

    @Test
    public void minimumWithNegativeMarksTest() {
        Student[] sdata = {
            new Student("S1", "An", "Bn", -20, 0, 0, "F"),     // -20
            new Student("S2", "Cn", "Dn", -5, -5, -5, "F")     // -15
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
    
    /**
     * The following tests are for validateRanges() in 
     * com.mycompany.gradesystem.GradeAnalyser.java
     * 
     */
    
    // tests for valid input range
    @Test
    public void validateRangesValidTest() {
        // Create a GradeAnalyser with no student data
        GradeAnalyser ga = new GradeAnalyser(new Student[]{});

        // Validate a correct range input
        GradeAnalyser.RangeValidationResponse res = ga.validateRanges("40", "80");

        //Expect valid result with correct bounds
        assertTrue(res.result());
        assertNotNull(res.range());
        assertEquals(40, res.range().lower());
        assertEquals(80, res.range().upper());
        assertEquals("", res.message());
    }
    
    // tests for missing input range
    @Test
    public void validateRangesEmptyFieldsTest() {
        //Validate when both fields are empty
        GradeAnalyser ga = new GradeAnalyser(new Student[]{});
        GradeAnalyser.RangeValidationResponse res = ga.validateRanges("", "");

        // Validation should fail with appropriate message
        assertFalse(res.result());
        assertNull(res.range());
        assertEquals("both bounds must be specified", res.message());
    }
    
    // test for non-numeric values passed
    @Test
    public void validateRangesNonNumericTest() {
        // Validate when lower bound is not a number
        GradeAnalyser ga = new GradeAnalyser(new Student[]{});
        GradeAnalyser.RangeValidationResponse res = ga.validateRanges("a", "80");

        // Validation should fail with numeric input error
        assertFalse(res.result());
        assertNull(res.range());
        assertEquals("Range fields must be positive numbers (digits only)", res.message());
    }
    
    // test for out-of-bounds ranges
    @Test
    public void validateRangesOutOfBoundsTest() {
        // Validate when upper bound exceeds allowed maximum
        GradeAnalyser ga = new GradeAnalyser(new Student[]{});
        GradeAnalyser.RangeValidationResponse res = ga.validateRanges("10", "150");

        // Validation should fail due to upper bound > 100
        assertFalse(res.result());
        assertNull(res.range());
        assertEquals("lower bound must be >=0 and upper bound must be <=100", res.message());
    }
    
    // test for lower bound greater than upper bound
    @Test
    public void validateRangesLowerGreaterThanUpperTest() {
        // Validate when lower bound is greater than upper bound
        GradeAnalyser ga = new GradeAnalyser(new Student[]{});
        GradeAnalyser.RangeValidationResponse res = ga.validateRanges("80", "40");

        // Validation should fail due to incorrect ordering
        assertFalse(res.result());
        assertNull(res.range());
        assertEquals("Upper bound must be greater than lower bound", res.message());
    }
    
    /**
    * Unit tests for the getStudentRecordsInRange(int lower, int upper) method
    * in the GradeAnalyser class.
    *
    * These tests cover:
    * - normal matches
    * - Empty student list
    * - No matches in range
    * - All students matching the range
    * - Students with total marks exactly on the bounds
    * - Lower = 0 and Upper = 100 edge case
    */
    
    // test for normal range
   @Test
   public void getStudentRecordsInRangeNormalTest() {
       //Setup students with different total marks
       Student[] sdata = {
           new Student("S1", "John", "Doe", 10, 20, 20, "P"),   // total = 50
           new Student("S2", "Jane", "Smith", 20, 30, 40, "HD"),// total = 90
           new Student("S3", "Alex", "Brown", 5, 10, 15, "F")   // total = 30
       };
       GradeAnalyser ga = new GradeAnalyser(sdata);

       // Filter range 40–95
       List<Student> result = ga.getStudentRecordsInRange(40, 95);

       // Expect 2 matches (S1 and S2)
       assertEquals(2, result.size());
   }
   
   // test with empty list
   @Test
   public void getStudentRecordsInRangeEmptyListTest() {
       // Empty student data
       GradeAnalyser ga = new GradeAnalyser(new Student[]{});

       //Call method with any range
       List<Student> result = ga.getStudentRecordsInRange(0, 100);

       // Expect no matches
       assertTrue(result.isEmpty());
   }

   // test with no matching marks
   @Test
   public void getStudentRecordsInRangeNoMatchesTest() {
       // Students all below range
       Student[] sdata = {
           new Student("S1", "John", "Doyle", 5, 5, 5, "F"),   // total = 15
           new Student("S2", "Janet", "Smith", 10, 10, 10, "F") // total = 30
       };
       GradeAnalyser ga = new GradeAnalyser(sdata);

       // Range excludes all students
       List<Student> result = ga.getStudentRecordsInRange(50, 100);

       // No matches
       assertTrue(result.isEmpty());
   }
   
   // test with same range and marks 
   @Test
   public void getStudentRecordsInRangeAllMatchTest() {
       // All students within the range
       Student[] sdata = {
           new Student("S1", "Allen", "Bob", 10, 20, 30, "P"),  // total = 60
           new Student("S2", "Catherine", "Layman", 20, 20, 20, "P")   // total = 60
       };
       GradeAnalyser ga = new GradeAnalyser(sdata);

       // Full inclusive range that covers all
       List<Student> result = ga.getStudentRecordsInRange(60, 60);

       // Both students match exactly
       assertEquals(2, result.size());
   }

   // boundary value test 
   @Test
   public void getStudentRecordsInRangeExactBoundsTest() {
       // One student on each bound
       Student[] sdata = {
           new Student("S1", "Low", "Bound", 10, 10, 10, "F"), // total = 30
           new Student("S2", "High", "Bound", 20, 30, 50, "HD") // total = 100
       };
       GradeAnalyser ga = new GradeAnalyser(sdata);

       // Search from 30 to 100 inclusive
       List<Student> result = ga.getStudentRecordsInRange(30, 100);

       // Both should be included
       assertEquals(2, result.size());
   }
   
   // edge cases test.
   @Test
   public void getStudentRecordsInRangeLower0Upper100Test() {
       // Arrange: Students with total marks at edge values
       Student[] sdata = {
           new Student("S1", "Edge", "Low", 0, 0, 0, "F"),     // total = 0
           new Student("S2", "Edge", "High", 20, 30, 50, "HD") // total = 100
       };
       GradeAnalyser ga = new GradeAnalyser(sdata);

       // Act: Full boundary range
       List<Student> result = ga.getStudentRecordsInRange(0, 100);

       // Assert: Both should be returned
       assertEquals(2, result.size());
   }

   @Test
   public void getStudentRecordsInRangeOnlyOneMatchTest() {
       // Only one student should fall in the range
       Student[] sdata = {
           new Student("S1", "Amy", "Williams", 5, 5, 5, "F"),     // total = 15
           new Student("S2", "Rhoda", "King", 20, 30, 40, "HD")  // total = 90
       };
       GradeAnalyser ga = new GradeAnalyser(sdata);

       // Range that includes only second student
       List<Student> result = ga.getStudentRecordsInRange(80, 95);

       // One match
       assertEquals(1, result.size());
   }

    
}
