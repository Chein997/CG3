module com.chein.task3_1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires org.junit.jupiter.api;
    requires org.junit.platform.commons;
    requires junit;
    requires org.slf4j;


    opens com.chein.task3_1 to javafx.fxml;
    exports com.chein.task3_1;
    exports com.chein.test;
}