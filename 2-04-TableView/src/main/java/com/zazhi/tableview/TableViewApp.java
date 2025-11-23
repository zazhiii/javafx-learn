package com.zazhi.tableview;

import com.zazhi.tableview.pojo.Item;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TableViewApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // TableView<S>, S -- 每一行所对应的对象类型
        TableView<Item> tableView = new TableView<>();

        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


        VBox.setVgrow(tableView, Priority.ALWAYS);

        TableColumn<Item, String> colSKU = new TableColumn<>("SKU");
        TableColumn<Item, String> colDescr = new TableColumn<>("Item");
        TableColumn<Item, Float> colPrice = new TableColumn<>("Price");
        TableColumn<Item, Boolean> colTaxable = new TableColumn<>("Tax");
        TableColumn<Item, Color> colColor = new TableColumn<Item, Color>("Color");

        colSKU.setCellValueFactory(new PropertyValueFactory<>("sku"));
        colDescr.setCellValueFactory(new PropertyValueFactory<>("descr"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colTaxable.setCellValueFactory(new PropertyValueFactory<>("taxable"));
        colColor.setCellValueFactory(data -> data.getValue().colorProperty());

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

        tableView.getColumns().addAll(
                colSKU, colDescr, colPrice, colTaxable, colColor
        );

        tableView.getItems().addAll(
                new Item("KBD-0455892", "Mechanical Keyboard", 100.0f, true, Color.RED),
                new Item("145256", "Product Docs", 0.0f, false, Color.BLUE),
                new Item("OR-198975", "O-Ring (100)", 10.0f, true, Color.PINK)
        );

        // region 选中API
        // 设置可以多选，默认为单选
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Button btnInventory = new Button("Inventory");
        Button btnCalcTax = new Button("Tax");

        btnInventory.disableProperty().bind(
                tableView.getSelectionModel().selectedItemProperty().isNull()
        );

        btnCalcTax.disableProperty().bind(
                tableView.getSelectionModel().selectedItemProperty().isNull().or(
                        Bindings.select(
                                tableView.getSelectionModel().selectedItemProperty(),
                                "taxable"
                        ).isEqualTo(false)
                )
        );
        // endregion

        HBox buttonHBox = new HBox(btnInventory, btnCalcTax);
        buttonHBox.setSpacing(8);

        VBox vbox = new VBox(tableView, buttonHBox);
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);

        Scene scene = new Scene(vbox);

        primaryStage.setTitle("TableSelectApp");
        primaryStage.setScene(scene);
        primaryStage.setHeight(376);
        primaryStage.setWidth(667);
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}