package com.zazhi.stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * @author zazhi
 * @date 2026/10/10
 * @description:
 */
public class StageFullScreenModeExampleApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(new Label("Full Screen Mode Example")));

        primaryStage.setFullScreen(true);

        primaryStage.show();
    }
}
