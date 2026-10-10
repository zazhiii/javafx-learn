package com.zazhi.button;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * @author zazhi
 * @date 2026/10/10
 * @description:
 */
public class ButtonTextExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Button button = new Button();

        // 设置按钮文本
        button.setText("Click Me!");
        // 设置按钮字体样式
        button.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        // 允许文本换行
        button.setWrapText(true);

        stage.setTitle("Button Text Example");
        stage.setScene(new Scene(button, 300, 200));
        stage.show();
    }
}
