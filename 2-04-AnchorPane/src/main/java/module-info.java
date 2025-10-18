module anchorpane {
    requires javafx.controls;

    opens com.zazhi.anchor to javafx.fxml;
    exports com.zazhi.anchor;
}