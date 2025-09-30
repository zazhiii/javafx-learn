import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TransformApp extends Application {

    private Parent createContent() {
        Rectangle box = new Rectangle(100, 100, Color.BLUE);

        transform(box);

        return new Pane(box);
    }

    private void transform(Rectangle box) {
        // we will apply transformations here

        // 1. 移动
        box.setTranslateX(100);
        box.setTranslateY(100);

        // 2. 缩放
        box.setScaleX(1.5);
        box.setScaleY(0.5);

        // 3. 旋转
        box.setRotate(45);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent(), 300, 300, Color.GRAY));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}