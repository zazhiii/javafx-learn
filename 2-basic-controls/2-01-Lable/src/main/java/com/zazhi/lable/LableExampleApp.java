package com.zazhi.lable;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author zazhi
 * @date 2026/10/10
 * @description:
 */
public class LableExampleApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Label Example");

        // 1. create a label
        Label label = new Label("A JavaFX Label");

        // 修改标签的文本
        label.setText("Hello, JavaFX! This is a Label example.");

        // 设置字体和大小
        label.setFont(new Font("Arial", 24));

        // 2. set the label as the scene root
        primaryStage.setScene(new Scene(label, 400, 300));

        // 3. show the stage
        primaryStage.show();
    }
}
