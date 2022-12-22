module com.example.hellojavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.hellojavafx to javafx.fxml;
    exports com.example.hellojavafx;
}