module com.jlba.oop2javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.jlba.oop2javafx to javafx.fxml;
    exports com.jlba.oop2javafx;
    exports com.jlba.oop2javafx.NoFXML;
    opens com.jlba.oop2javafx.NoFXML to javafx.fxml;
}