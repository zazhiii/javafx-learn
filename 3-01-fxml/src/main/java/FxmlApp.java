import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author zazhi
 * @date 2025/10/1
 * @description: FXML (FXML Markup Language) 是一种基于XML的标记语言，用于定义JavaFX应用程序的用户界面。
 * 它允许开发者将UI布局与应用程序逻辑分离，从而提高代码的可维护性和可读性。
 */
public class FxmlApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = (Pane) FXMLLoader.load(getClass().getResource("FxmlApp.fxml"));

        // 另一种加载方式，可以获取控制器，调用控制器中的方法操作节点
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FxmlApp.fxml"));
//        Parent parent = (Parent) fxmlLoader.load();
//        ModuleLayer.Controller controller = fxmlLoader.getController();

        Scene scene = new Scene(pane, 400, 300);
        stage.setScene(scene);
        stage.setTitle("FXML Example");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
