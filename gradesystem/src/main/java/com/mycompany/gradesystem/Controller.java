/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.gradesystem;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
/**
 * This FXML Controller class connects GUI side with backend side of the project.
 * It implements all the button functions in the GUI. 
 *
 * @author Ujjwal Dhakal (12222900)
 */
public class Controller implements Initializable {

    private GradeAnalyser gradeAnalyser;    // Instance variable of GradeAnalyser
    @FXML
    private Button btnDisplayAllGrades;
    @FXML
    private Button btnFindStudentId;
    @FXML
    private Button btnResultsInMarkRange;
    @FXML
    private Button btnDisplayStatistics;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnExit;
    @FXML
    private TextField txtStudentId;
    @FXML
    private TextField txtMinRange;
    @FXML
    private TextField txtMaxRange;
    @FXML
    private TextArea txtAreaDisplay;
    @FXML
    private Text lblActions;
    @FXML
    private Text lblOutput;
    
    public void inject(GradeAnalyser analyser) {
        this.gradeAnalyser = analyser;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    /**
     * This button when clicked displays all the grades of the students
     * 
     * @param event click event of the button
     */
    
    @FXML
    private void displayAllGradesActionBtn(ActionEvent event) {
        
        this.txtAreaDisplay.setText("This button displays all grades. Feature arriving soon.");
        if (gradeAnalyser == null) {
            this.txtAreaDisplay.setText("Error: GradeAnalyser is not injected.");
            return;
        }

        StringBuilder output = new StringBuilder();

        for (Student student : gradeAnalyser.getOrderedList()) {
            output.append(student).append("\n");
        }

        this.txtAreaDisplay.setText(output.toString()); // Display all grades
    }
    
    /**
     * This method displays the student details according to provided id if exists
     * 
     * @param event click event of the button
     */
    
    @FXML
    private void findStudentIdActionBtn(ActionEvent event) {
        String id = txtStudentId.getText().trim();
        Student student = gradeAnalyser.find(id);
        
        if(student != null)
        {
            this.txtAreaDisplay.setText(student.toString());    // Display Student details if exists
        }
        else
        {
            this.txtAreaDisplay.setText("Sorry no students are associated with id: " + id);
        }
    }
    
    /**
     * This method displays all the student details within certain range of total
     * marks.
     * 
     * @param event click event of the button
     */
    
    @FXML
    private void resultsInMarkRangeActionBtn(ActionEvent event) {
        
        String lower = this.txtMinRange.getText();  // collecting min range input field.
        String upper = this.txtMaxRange.getText();  // collecting max range input field.
        
        GradeAnalyser.RangeValidationResponse response = gradeAnalyser.validateRanges(lower, upper);
        
        // verifies the result returned after validation.
        if (!response.result())
        {
            this.txtAreaDisplay.setText("Error: " + response.message());
        }
        else
        {
            List<Student> results = gradeAnalyser.getStudentRecordsInRange(
                    response.range().lower(), response.range().upper());
            
            StringBuilder output = new StringBuilder ("Students in Range:\n");
            for(Student s : results)
            {
                output.append(s).append("\n");
            }
            
            this.txtAreaDisplay.setText(output.toString()); // displays student details within range 
        }
        
    }
    
    /**
     * This method displays statistics of marks of the whole class
     * 
     * @param event click event of button
     */
    
    @FXML
    private void displayStatisticsActionButton(ActionEvent event) {
            try {
                double avg = gradeAnalyser.averageMark();
                double median = gradeAnalyser.medianMark();
                int max = gradeAnalyser.maximum();
                int min = gradeAnalyser.minimum();

                this.txtAreaDisplay.setText("Statistics:\n\n"
                              + "Average Marks: " + avg + "\n"
                              + "Median Marks:  " + median + "\n"
                              + "Maximum Marks: " + max + "\n"
                              + "Minimum Marks: " + min);
        } catch (EmptyListException e) {
            this.txtAreaDisplay.setText("Error: " + e.getMessage());    // Display Statistics 
        }
    }

    /**
     * This method clears all the text input and output streams in GUI
     * 
     * @param event click event of the button
     */
    
    @FXML
    private void clearActionBtn(ActionEvent event) {
        this.txtStudentId.setText("");  // clears textbox
        this.txtMinRange.setText("");  // clears textbox   
        this.txtMaxRange.setText("");  // clears textbox        
        this.txtAreaDisplay.setText("");  // clears text area
    }
    
    /**
     * This method asks for the confirmation to exit 
     * 
     * @param event click event of button
     */
    
    @FXML
    private void exitActionBtn(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you really want to close the application?");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                Platform.exit();    // exits
            }
        });

    }

}
