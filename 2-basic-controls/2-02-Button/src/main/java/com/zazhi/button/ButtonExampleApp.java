package com.zazhi.button;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author zazhi
 * @date 2026/10/10
 * @description:
 */
public class ButtonExampleApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Button button = new Button("I am a Button");

        stage.setScene(new Scene(button, 300, 200));
        stage.setTitle("Button Example");
        stage.show();
    }
}
