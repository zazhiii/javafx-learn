package fillWidth;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

/**
 * @author zazhi
 * @date 2026/8/21
 * @description:
 */
public class App extends Application {
    @Override
    public void start(Stage stage) {


        Button button1 = new Button("Button1");
        Button button2 = new Button("Button2");

        VBox vbox = new VBox();
        vbox.setPrefWidth(300);
        vbox.setBackground(Background.fill(Paint.valueOf("pink")));
        vbox.setFillWidth(true);
        vbox.setSpacing(10);
        vbox.getChildren().addAll(button1, button2);

        Label label1 = new Label("设置button1的maxWidth");
        Label label2 = new Label("设置button2的maxWidth");
        Label label3 = new Label("设置vBox的fillWidth");
        ChoiceBox<Double> choiceBox1 = new ChoiceBox<>(
                FXCollections.observableArrayList(-1.0, 300.0, Double.MAX_VALUE)
        );
        ChoiceBox<Double> choiceBox2 = new ChoiceBox<>(
                FXCollections.observableArrayList(-1.0, Double.MAX_VALUE)
        );
        ChoiceBox<Boolean> choiceBox3 = new ChoiceBox<>(
                FXCollections.observableArrayList(true, false)
        );
        choiceBox1.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    button1.setMaxWidth(newValue);
                });
        choiceBox2.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    button2.setMaxWidth(newValue);
                });
        choiceBox3.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    vbox.setFillWidth(newValue);
                });
        HBox selectHBox1 = new HBox(label1, choiceBox1);
        HBox selectHBox2 = new HBox(label2, choiceBox2);
        HBox selectHBox3 = new HBox(label3, choiceBox3);



        String explanation = """
                fillWidth属性的含义：VBox 要不要把“可调整大小的子节点”横向拉伸到和自己一样宽。
                
                如果设置为 true，则 VBox 会尝试将可调整大小的子节点拉伸到和 VBox 一样宽。
                
                但不是“无条件把所有子节点拉满”，
                而是：VBox 会尝试把可调整大小的子节点拉到自己的可用宽度，但仍然要遵守子节点的 minWidth / prefWidth / maxWidth 限制。
                
                如果子节点的 maxWidth 小于 VBox 的宽度，则 VBox 会把子节点拉伸到它的 maxWidth，而不是 VBox 的宽度。
                """;


        VBox vBox = new VBox(
                vbox,
                selectHBox1,
                selectHBox2,
                selectHBox3,
                new Label(explanation)
        );
        vBox.setSpacing(5);
        Pane pane = new Pane(vBox);
        stage.setScene(new Scene(pane, 900, 600));
        stage.show();
    }
}
