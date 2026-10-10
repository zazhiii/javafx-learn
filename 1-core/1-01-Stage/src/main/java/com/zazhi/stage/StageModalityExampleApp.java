package com.zazhi.stage;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author zazhi
 * @date 2026/10/10
 * @description:
 */
public class StageModalityExampleApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Primary Stage");

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL); // 设置为应用程序模态，阻止与该应用程序的其他窗口交互

        // 设置所属 stage
        stage.initOwner(primaryStage);

        primaryStage.show();

        stage.show();
    }
}
