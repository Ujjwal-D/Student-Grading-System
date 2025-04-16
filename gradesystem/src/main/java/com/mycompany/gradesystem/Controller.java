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
 * FXML Controller class
 *
 * @author Ujjwal
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
    
    // Display all grades button
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

        this.txtAreaDisplay.setText(output.toString());
    }
    
    // Find Student Id Button
    @FXML
    private void findStudentIdActionBtn(ActionEvent event) {
        String id = txtStudentId.getText().trim();
        Student student = gradeAnalyser.find(id);
        
        if(student != null)
        {
            this.txtAreaDisplay.setText(student.toString());
        }
        else
        {
            this.txtAreaDisplay.setText("Sorry no students are associated with id: " + id);
        }
    }
    
    // Results in Range Button
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
            
            this.txtAreaDisplay.setText(output.toString());
        }
        
    }
    
    // Display Statistics Button
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
            this.txtAreaDisplay.setText("Error: " + e.getMessage());
        }
    }

    // Clear Button
    @FXML
    private void clearActionBtn(ActionEvent event) {
        this.txtStudentId.setText("");
        this.txtMinRange.setText("");
        this.txtMaxRange.setText("");        
        this.txtAreaDisplay.setText("");
    }

    // Exit Button 
    @FXML
    private void exitActionBtn(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you really want to close the application?");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                Platform.exit();
            }
        });

    }

}
