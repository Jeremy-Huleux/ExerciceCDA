module com.example.jpaentitygenerator {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.sql;
    requires org.slf4j;

    opens com.example.jpaentitygenerator to javafx.fxml;
    exports com.example.jpaentitygenerator;
}