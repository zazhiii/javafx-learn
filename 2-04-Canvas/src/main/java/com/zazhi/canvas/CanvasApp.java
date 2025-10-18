package com.zazhi.canvas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author zazhi
 * @date 2025/10/12
 * @description: Canvas 是 JavaFX 提供的一个用于绘制图形的节点。它提供了一个可绘制的区域，开发者可以在其上进行各种图形操作，如绘制线条、形状、文本和图像等。
 * Canvas 通常用于需要自定义绘图的场景，例如游戏开发、数据可视化和图形编辑器等。
 * Canvas 提供了一个 GraphicsContext 对象，通过它可以执行各种绘图操作。GraphicsContext 提供了丰富的方法来设置绘图属性（如颜色、线条宽度、字体等）以及绘制各种图形元素。
 * Canvas 的大小可以通过 setWidth 和 setHeight 方法进行设置，默认情况下，Canvas 的大小为 0x0，因此在使用前需要显式设置其尺寸。
 * Canvas 还支持双缓冲技术，可以通过创建多个 Canvas 实例并在它
 * 们之间切换来实现平滑的动画效果。
 * Canvas 适合用于需要频繁更新绘图内容的场景，因为它允许直接操作像素数据，从而提高绘图性能。
 * 需要注意的是，Canvas 不支持布局管理，因此在使用时需要手动设置其位置和大小。
 * 总之，Canvas 是一个强大的绘图工具，适用于各种需要自定义图形渲染的 JavaFX 应用程序。
 */
public class CanvasApp extends Application {
    private static final Integer WIDTH = 800, HEIGHT = 600;
    private Canvas canvas = new Canvas(WIDTH, HEIGHT);
    private GraphicsContext gc = canvas.getGraphicsContext2D();

    @Override
    public void start(Stage stage) throws Exception {
        canvas.setLayoutX(0);
        canvas.setLayoutY(0);

        // 绘制一个绿色的矩形框
        gc.setLineWidth(5);
        gc.setStroke(Color.GREEN);
        gc.strokeRect(10, 10, 100, 100);

        // 绘制填充矩形
        gc.setFill(Color.BLUE);
        gc.fillRect(120, 10, 100, 100);

        // 绘制圆形
        gc.setFill(Color.RED);
        gc.fillOval(230, 10, 100, 100);

        // 绘制线条
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.strokeLine(10, 150, 200, 250);

        // 绘制文本
        gc.setFill(Color.PURPLE);
        gc.fillText("Hello, Canvas!", 10, 300);

        AnchorPane anchorPane = new AnchorPane(canvas);
        Scene scene = new Scene(anchorPane, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
