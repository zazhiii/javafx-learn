package com.zazhi.tableview;

import com.zazhi.tableview.pojo.Item;
import com.zazhi.tableview.pojo.Person;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class TableViewApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // TableView<S>, S -- 每一行所对应的对象类型
        TableView<Item> tableView1 = new TableView<>();

        tableView1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        VBox.setVgrow(tableView1, Priority.ALWAYS);

        // 定义 TableColumn, 第一个泛型参数为 TableView 对应的对象类型，第二个泛型参数为该列对应的数据类型
        // 构造器中传入的字符串为该列的标题
        TableColumn<Item, String> colSKU = new TableColumn<>("SKU");
        TableColumn<Item, String> colDescr = new TableColumn<>("Item");
        TableColumn<Item, Float> colPrice = new TableColumn<>("Price");
        TableColumn<Item, Boolean> colTaxable = new TableColumn<>("Tax");
        TableColumn<Item, Color> colColor = new TableColumn<>("Color");

        // 每个 TableColumn 需要设置一个 CellValueFactory，用于提取每个单元格需要显示的数据
        // PropertyValueFactory 可以从 JavaBean 对象中提取属性值，构造器中传入的字符串为对应的属性名称
        colSKU.setCellValueFactory(new PropertyValueFactory<>("sku"));
        colDescr.setCellValueFactory(new PropertyValueFactory<>("descr"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colTaxable.setCellValueFactory(new PropertyValueFactory<>("taxable"));
        colColor.setCellValueFactory(data -> data.getValue().colorProperty());

        // region 自定义单元格
        colColor.setCellFactory(p -> {
            return new TableCell<Item, Color>() {
                private final Rectangle rectangle;

                {
                    setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                    rectangle = new Rectangle(10, 10);
                }

                @Override
                protected void updateItem(Color color, boolean empty) {
                    super.updateItem(color, empty);
                    if (color == null || empty) {
                        setGraphic(null);
                    } else {
                        rectangle.setFill(color);
                        setGraphic(rectangle);
                    }
                }
            };
        });
        // endregion

        tableView1.getColumns().addAll(
                colSKU, colDescr, colPrice, colTaxable, colColor
        );

        // 添加数据
        tableView1.getItems().addAll(
                new Item("KBD-0455892", "Mechanical Keyboard", 100.0f, true, Color.RED),
                new Item("145256", "Product Docs", 0.0f, false, Color.BLUE),
                new Item("OR-198975", "O-Ring (100)", 10.0f, true, Color.PINK)
        );

        // region 选中API
        // 获取SelectionModel对象
        TableView.TableViewSelectionModel<Item> selectionModel = tableView1.getSelectionModel();

        // 设置可以单选（默认就是单选）
        // selectionModel.setSelectionMode(SelectionMode.SINGLE);
        // 设置单元多选，按住shift和ctrl
        selectionModel.setSelectionMode(SelectionMode.MULTIPLE);

        // 获取选中的行
        ObservableList<Item> selectedItems = selectionModel.getSelectedItems();

        // 获取选中行的索引
        ObservableList<Integer> selectedIndices = selectionModel.getSelectedIndices();
        Label label = new Label("No rows selected");
        selectedIndices.addListener(
                new ListChangeListener<Integer>() {
                    @Override
                    public void onChanged(Change<? extends Integer> change) {
                        String str = selectedIndices.stream().map(String::valueOf).collect(Collectors.joining(","));
                        label.setText("selected rows: " + str + " row");
                    }
                }
        );


        // 清除选中
        Button clearSelectionBtn = new Button("Clear selection");
        clearSelectionBtn.setOnAction(e -> {
            selectionModel.clearSelection();
            label.setText("No rows selected");
        });

        // 通过程序选中
        Button randomSelectionBtn = new Button("Random selection");
        randomSelectionBtn.setOnAction(e -> {
            selectionModel.select(new Random().nextInt(tableView1.getItems().size()));
        });

        HBox table1ButtonHox = new HBox(clearSelectionBtn, randomSelectionBtn);
        table1ButtonHox.setSpacing(10);
        VBox table1Vbox = new VBox(tableView1, label, table1ButtonHox);
        // endregion

        // region 用 Map 作为数据对象
        TableView<Map> tableView2 = new TableView<>();

        TableColumn<Map, String> colFirstName = new TableColumn<>("First Name");
        TableColumn<Map, String> colLastName = new TableColumn<>("Last Name");

        colFirstName.setCellValueFactory(new MapValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new MapValueFactory<>("lastName"));
        tableView2.getColumns().addAll(colFirstName, colLastName);

        Map<String, String> item1 = Map.of("firstName", "li", "lastName", "xinhuan");
        Map<String, String> item2 = Map.of("firstName", "hello", "lastName", "world");

        tableView2.getItems().addAll(item1, item2);
        // endregion

        // region 当没有数据时，设置一个placeholder
        TableView<Map> tableView3 = new TableView<>();
        tableView3.setPlaceholder(new Label("暂无数据"));
        tableView3.getColumns().addAll(colFirstName, colLastName);
        // endregion

        // region 可编辑的表格
        TableView tableView4 = new TableView();
        tableView4.setEditable(true);

        TableColumn<Person, String> column1 = new TableColumn<>("First Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Person, String> column2 = new TableColumn<>("Last Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        column2.setCellFactory(TextFieldTableCell.<Person>forTableColumn());

        TableColumn<Person, String> column3 = new TableColumn<>("Category");
        column3.setCellValueFactory(new PropertyValueFactory<>("category"));
        column3.setCellFactory(ComboBoxTableCell.<Person, String>forTableColumn("Category 1", "Category 2"));

        TableColumn<Person, Boolean> column4 = new TableColumn<>("Is XYZ");
        column4.setCellValueFactory(cellData -> new ReadOnlyBooleanWrapper(cellData.getValue().getIsXyz()));
        column4.setCellFactory(CheckBoxTableCell.<Person>forTableColumn(column4));


        tableView4.getColumns().add(column1);
        tableView4.getColumns().add(column2);
        tableView4.getColumns().add(column3);
        tableView4.getColumns().add(column4);

        tableView4.getItems().add(new Person("John", "Doe", null, false));
        tableView4.getItems().add(new Person("Jane", "Deer", "Category 1", true));
        tableView4.getItems().add(new Person("Dinesh", "Gupta", "Category 2", true));
        // endregion

        VBox vbox = new VBox(table1Vbox, tableView2, tableView3,  tableView4);
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);

        Scene scene = new Scene(vbox);

        primaryStage.setTitle("TableViewApp");
        primaryStage.setScene(scene);
        primaryStage.setHeight(600);
        primaryStage.setWidth(667);
        primaryStage.show();
    }
}