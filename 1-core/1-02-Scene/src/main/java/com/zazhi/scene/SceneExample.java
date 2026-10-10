package com.zazhi.scene;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * @author zazhi
 * @date 2026/10/10
 * @description:
 */
public class SceneExample extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene scene = new Scene(new Label("Scene Example"));

        scene.setCursor(Cursor.OPEN_HAND);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
