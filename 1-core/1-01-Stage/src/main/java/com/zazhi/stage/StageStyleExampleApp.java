package com.zazhi.stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author zazhi
 * @date 2026/10/10
 * @description:
 */
public class StageStyleExampleApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage decoratedStage = new Stage();
        Stage undecoratedStage = new Stage();
        Stage transparentStage = new Stage();
        Stage utilityStage = new Stage();
        Stage unifiedStage = new Stage();
        decoratedStage.initStyle(StageStyle.DECORATED);
        undecoratedStage.initStyle(StageStyle.UNDECORATED);
        transparentStage.initStyle(StageStyle.TRANSPARENT);
        utilityStage.initStyle(StageStyle.UTILITY);
        unifiedStage.initStyle(StageStyle.UNIFIED);

        decoratedStage.setX(10); decoratedStage.setWidth(400); decoratedStage.setHeight(300);

        undecoratedStage.setX(100); undecoratedStage.setWidth(400); undecoratedStage.setHeight(300);
        undecoratedStage.setScene(new Scene(new Label("UNDECORATED")));

        transparentStage.setX(200); transparentStage.setWidth(400); transparentStage.setHeight(300);
        transparentStage.setScene(new Scene(new Label("TRANSPARENT")));

        utilityStage.setX(300); utilityStage.setWidth(400); utilityStage.setHeight(300);
        utilityStage.setScene(new Scene(new Label("UTILITY")));

        unifiedStage.setX(400); unifiedStage.setWidth(400); unifiedStage.setHeight(300);
        unifiedStage.setScene(new Scene(new Label("UNIFIED")));

        decoratedStage.show();
        undecoratedStage.show();
        transparentStage.show();
        utilityStage.show();
        unifiedStage.show();
    }
}
