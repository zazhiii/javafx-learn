package com.zazhi.pageswitch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main.fxml"));
        Scene scene = new Scene(loader.load(), 900, 600);

        stage.setTitle("JavaFX Navigation Demo");
        stage.setScene(scene);
        stage.show();
    }
}
