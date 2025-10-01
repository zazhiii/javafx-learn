import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * @author zazhi
 * @date 2025/10/1
 * @description: 属性(Property)是JavaFX的核心概念之一，它提供了一种观察和绑定数据的机制，使得UI组件能够自动响应数据的变化。
 *
 * 1. 属性绑定
 * 2. 属性设置监听器
 *
 */
public class PropertyApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Circle circle = new Circle();
        circle.setRadius(50);
        circle.setCenterX(100);
        circle.setCenterY(100);
        circle.setStroke(Color.BLUE);
        circle.setFill(Color.LIGHTGRAY);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().add(circle);

        Scene scene = new Scene(anchorPane, 300, 300);

        // 绑定属性：将圆的中心位置绑定到场景的中心位置
        // 通过Property类的bind()方法
        circle.centerXProperty().bind(scene.widthProperty().divide(2));
        circle.centerYProperty().bind(scene.heightProperty().divide(2));

        // 监听属性变化：当圆的中心位置变化时，打印新的位置
        circle.centerXProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Circle centerX changed from " + oldValue + " to " + newValue);
        });

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
