package com.zazhi.stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author zazhi
 * @date 2026/10/10
 * @description:
 */
public class StageExampleApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        // 1. create a stage
        Stage stage = new Stage();

        // 3. set a scene on the stage
        stage.setScene(new Scene(new Label("A JavaFX Label in a Stage")));

        // 4. set the title of the stage
        stage.setTitle("A JavaFX Stage");

        // 5. set position of the stage
        stage.setX(200);
        stage.setY(200);

        // 6. set the width and height of the stage
        stage.setWidth(400);
        stage.setHeight(300);

        // 7. 设置模态 Modality
        stage.initModality(Modality.APPLICATION_MODAL); // 设置为应用程序模态，阻止与该应用程序的其他窗口交互
//        stage.initModality(Modality.WINDOW_MODAL); // 设置为窗口模态，阻止与指定父窗口的交互
//        stage.initModality(Modality.NONE); // 设置为非模态，允许与其他窗口交互

        // 2. show the stage
        stage.show();
    }
}
