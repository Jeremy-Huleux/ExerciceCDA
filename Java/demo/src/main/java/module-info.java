module org.example.rh.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.management;

    opens org.example.rh.demo to javafx.fxml;
    exports org.example.rh.demo;
}