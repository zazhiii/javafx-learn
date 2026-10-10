package com.zazhi.button;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author zazhi
 * @date 2026/10/10
 * @description:
 */
public class ButtonModeExample extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Button Mode Example");

        Button defaultButton = new Button("Default Button");
        defaultButton.setDefaultButton(true); // 设置为默认按钮

        Button cancelButton = new Button("Cancel Button");
        cancelButton.setCancelButton(true); // 设置为取消按钮

        primaryStage.setScene(new Scene(new VBox(10, defaultButton, cancelButton), 300, 200));
        primaryStage.show();
    }
}
