package com.zazhi.anchor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * @author lixh
 * @since 2025/10/17 23:00
 */
public class AnchorPaneApp extends Application {
    @Override
    public void start(Stage stage) {

        AnchorPane anchorPane = new AnchorPane();

        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");

        // 会调整button1的大小以适应AnchorPane的大小变化
        AnchorPane.setTopAnchor(button1, 30D);
        AnchorPane.setLeftAnchor(button1, 30D);
        AnchorPane.setBottomAnchor(button1, 30D);
        AnchorPane.setRightAnchor(button1, 30D);

        anchorPane.getChildren().addAll(button1, button2);

        Scene scene = new Scene(anchorPane, 300, 300);
        stage.setScene(scene);
        stage.setTitle("AnchorPane Example");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}