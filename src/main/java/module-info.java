module com.jlba.oop2javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.jlba.oop2javafx to javafx.fxml;
    exports com.jlba.oop2javafx;
}