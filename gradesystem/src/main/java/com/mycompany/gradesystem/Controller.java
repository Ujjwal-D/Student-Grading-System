/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.gradesystem;

import java.net.URL;
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
    }
    
    // Find Student Id Button
    @FXML
    private void findStudentIdActionBtn(ActionEvent event) {
        this.txtAreaDisplay.setText("This button find the students through their ids. Feature arriving soon.");
    }
    
    // Results in Range Button
    @FXML
    private void resultsInMarkRangeActionBtn(ActionEvent event) {
        this.txtAreaDisplay.setText("This button displays results of student within the range. Feature arriving soon.");
    }
    
    // Display Statistics Button
    @FXML
    private void displayStatisticsActionButton(ActionEvent event) {
        this.txtAreaDisplay.setText("This button displays all the statistics. Feature arriving soon.");
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
