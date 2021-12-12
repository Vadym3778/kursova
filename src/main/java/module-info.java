module com.example.kursova {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.kursova to javafx.fxml;
    exports com.example.kursova;
}