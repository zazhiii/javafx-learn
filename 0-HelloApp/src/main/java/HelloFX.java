import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloFX extends Application {

    @Override
    public void start(Stage primaryStage) {

        // 设置窗口标题
        primaryStage.setTitle("Hello JavaFX, My First JavaFX App");

        Label label = new Label("Hello JavaFX");
        Scene scene = new Scene(label, 640, 480);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}