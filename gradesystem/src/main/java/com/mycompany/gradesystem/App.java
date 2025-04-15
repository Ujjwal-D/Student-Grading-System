package com.mycompany.gradesystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new
                FXMLLoader(App.class.getResource("GradingSystem.fxml"));
        Parent root = loader.load();
        
        // construct the objects of DataSet and GradeAnalyser
        DataSet data = new DataSet();
        GradeAnalyser analyser = new GradeAnalyser(data);
        
        // gets the reference to controller object
        Controller controller = loader.getController();
        // injects the analyser into controller
        controller.inject(analyser);
        
        //scene = new Scene(loadFXML("GradingSystem"), 700, 480);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Student Grade System");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}