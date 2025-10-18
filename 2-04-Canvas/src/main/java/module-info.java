module com.zazhi.canvas {
    requires javafx.controls;

    exports com.zazhi.canvas;
    opens com.zazhi.canvas to javafx.fxml;
}