package com.zazhi.stage;

import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * @author zazhi
 * @date 2026/10/10
 * @description:
 */
public class StageLifeCycleEventsExampleApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Stage Life Cycle Events Example");

        // 注册生命周期事件
        primaryStage.setOnCloseRequest(event -> System.out.println("Stage is closing"));
        // 在 Stage 展示之前触发
        primaryStage.setOnShowing(event -> System.out.println("Stage is showing"));
        // 在 Stage 展示之后触发
        primaryStage.setOnShown(event -> System.out.println("Stage is shown"));
        // 同理
        primaryStage.setOnHiding(event -> System.out.println("Stage is hiding"));
        primaryStage.setOnHidden(event -> System.out.println("Stage is hidden"));

        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            System.out.println("Key Pressed: " + event.toString());

            switch (event.getCode()) {
                case KeyCode.ESCAPE: {
                    primaryStage.close();
                    break;
                }
                case KeyCode.PLUS: {
                    primaryStage.setWidth(primaryStage.getWidth() * 2);
                }
                default: {
                    System.out.println("Unrecognized key");
                }
            }
        });

        primaryStage.show();
    }
}
