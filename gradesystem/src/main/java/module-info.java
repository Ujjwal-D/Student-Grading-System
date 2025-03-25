module com.mycompany.gradesystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.gradesystem to javafx.fxml;
    exports com.mycompany.gradesystem;
}
