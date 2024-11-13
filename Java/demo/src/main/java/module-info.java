module org.example.rh.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.management;
    requires java.sql;

    opens org.example.rh.demo to javafx.fxml;
    exports org.example.rh.demo;
    exports org.example.rh.demo.Model;
    opens org.example.rh.demo.Model to javafx.fxml;
    exports org.example.rh.demo.DTO;
    opens org.example.rh.demo.DTO to javafx.fxml;
}