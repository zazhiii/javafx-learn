package com.zazhi.graphics2d;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

/**
 * @author zazhi
 * @date 2025/10/18
 * @description:
 */
public class Graphics2dApp extends Application {
    @Override
    public void start(Stage stage) {

        // ========== 绘制线条 ==========
        Line line = new Line(0, 0, 200, 200);
        line.setStroke(Color.BLUE); // 设置线条颜色
        line.setStrokeWidth(15); // 设置线条宽度
        line.setStrokeLineCap(StrokeLineCap.ROUND); // 设置线条端点样式

        // ========= 绘制多段线 ==========
        Polyline polyline = new Polyline(0, 0, 200, 200, 200, 0, 0, 200);
        polyline.setStroke(Color.RED);
        polyline.setStrokeWidth(10);
        polyline.setStrokeLineCap(StrokeLineCap.ROUND);
        polyline.setStrokeLineJoin(StrokeLineJoin.BEVEL); // 设置线条连接点样式
        polyline.setFill(Color.LIGHTGRAY); // 设置填充颜色

        // ========= 绘制矩形 ==========
        Rectangle rectangle = new Rectangle(0, 0, 200, 200);
        rectangle.setFill(Color.LIGHTGRAY);
        rectangle.setStroke(Color.RED);
        rectangle.setStrokeWidth(5);
        rectangle.setStrokeType(StrokeType.OUTSIDE); // 设置描边类型(描边在形状外侧/内侧/居中)

        // ========= 绘制圆形 ==========
        Circle circle = new Circle(100, 100, 100, Color.LIGHTGRAY); // (centerX, centerY, radius, fill)

        // ========= 绘制椭圆 ==========
        Ellipse ellipse = new Ellipse(100, 100, 80, 50);// (centerX, centerY, radiusX, radiusY)
        ellipse.setFill(Color.LIGHTGRAY);

        // ========= 绘制弧形 ==========
        Arc arc = new Arc();
        arc.setCenterX(0);
        arc.setCenterY(0);
        arc.setRadiusX(50);
        arc.setRadiusY(80);
        arc.setStartAngle(45);
        arc.setLength(270);
        arc.setType(ArcType.ROUND);
        arc.setFill(Color.LIGHTGRAY);

        // ========= 绘制多边形 ==========
        Polygon polygon = new Polygon(0, 0, 100, 0, 50, 100); // (x1, y1, x2, y2, x3, y3, ...)
        polygon.setFill(Color.LIGHTGRAY);

        // ========= 二次曲线 ==========
        QuadCurve quadCurve = new QuadCurve(0, 100, 100, 0, 200, 100); // (startX, startY, controlX, controlY, endX, endY)
        quadCurve.setStroke(Color.GREEN);

        // ========== 三次曲线 ==========
        // (startX, startY, controlX1, controlY1, controlX2, controlY2, endX, endY)
        CubicCurve cubicCurve = new CubicCurve(0, 100, 50, 0, 150, 200, 200, 100);
        cubicCurve.setStroke(Color.PURPLE);
        cubicCurve.setFill(Color.TRANSPARENT);
        cubicCurve.setStrokeWidth(5);

        // ========== 路径绘制 ==========
        Path path = new Path();
        MoveTo moveTo = new MoveTo(0, 0);
        LineTo lineTo = new LineTo(100, 0);
        QuadCurveTo quadCurveTo = new QuadCurveTo(150, 50, 100, 100);
        path.getElements().addAll(moveTo, lineTo, quadCurveTo);

        // ========== SVG路径绘制 ==========
        SVGPath svg = new SVGPath();
        svg.setContent("M40,60 C42,48 44,30 25,32");

        HBox hBox = new HBox(20);
        hBox.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        hBox.getChildren().addAll(line, polyline, rectangle, circle, ellipse, arc, polygon, quadCurve);

        HBox hBox2 = new HBox(20);
        hBox2.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        hBox2.getChildren().addAll(cubicCurve, path, svg);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox, hBox2);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().add(vBox);
        AnchorPane.setTopAnchor(vBox, 10.0);
        AnchorPane.setLeftAnchor(vBox, 10.0);
        AnchorPane.setRightAnchor(vBox, 10.0);
        AnchorPane.setBottomAnchor(vBox, 10.0);

        stage.setScene(new Scene(anchorPane, 1600, 900));
        stage.setTitle("Graphics 2D");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
