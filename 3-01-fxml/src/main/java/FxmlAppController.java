import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


/**
 * @author zazhi
 * @date 2025/10/1
 * @description:
 */
public class FxmlAppController {
    @FXML
    Label lb;
    @FXML
    Button bt;

    public void moveUp(){
        lb.setLayoutY(lb.getLayoutY() - 10);
    }

    // FXML 会在加载 FXML 文件时自动调用这个方法
    // 常用的做法是在这里给组件填充数据
    public void initialize(){
        System.out.println("FxmlAppController initialized");
    }
}
