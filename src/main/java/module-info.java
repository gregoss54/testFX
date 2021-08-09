module fr.greg.testfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.greg.testfx to javafx.fxml;
    exports fr.greg.testfx;
}