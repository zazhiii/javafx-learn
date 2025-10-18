package com.zazhi.timeline;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * @author zazhi
 * @date 2025/10/18
 * @description:
 */
public class TimelineApp extends Application {
    @Override
    public void start(Stage stage) {

        Rectangle rect = new Rectangle(100, 100, 20, 20);
        rect.setFill(Color.GREEN);


        KeyFrame keyFrame1 = new KeyFrame(
                Duration.seconds(1),
                new KeyValue(rect.translateXProperty(), 0),
                new KeyValue(rect.translateYProperty(), 200),
                new KeyValue(rect.rotateProperty(), -360),
                new KeyValue(rect.scaleXProperty(), 2),
                new KeyValue(rect.scaleYProperty(), 2),
                new KeyValue(rect.fillProperty(), Color.RED)
        );
        KeyFrame keyFrame2 = new KeyFrame(
                Duration.seconds(2),
                new KeyValue(rect.translateXProperty(), 200),
                new KeyValue(rect.translateYProperty(), 200),
                new KeyValue(rect.rotateProperty(), 360),
                new KeyValue(rect.scaleXProperty(), 0.5),
                new KeyValue(rect.scaleYProperty(), 0.5),
                new KeyValue(rect.fillProperty(), Color.BLUE)
        );
        // (帧率, 关键帧...)
        Timeline timeline = new Timeline(165, keyFrame1, keyFrame2);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        timeline.play();


        AnchorPane anchorPane = new AnchorPane(rect);
        stage.setScene(new Scene(anchorPane, 400, 400));
        stage.setTitle("Timeline Example");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
