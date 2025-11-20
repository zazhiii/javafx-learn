package com.zazhi.pageswitch.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class MainController {

    @FXML
    private AnchorPane contentArea;

    @FXML
    public void initialize() {
        switchPage("home.fxml");
    }

    @FXML
    public void switchToHome() {
        switchPage("home.fxml");
    }

    @FXML
    public void switchToSetting() {
        switchPage("setting.fxml");
    }

    @FXML
    public void switchToAbout() {
        switchPage("about.fxml");
    }

    private void switchPage(String fxml) {
        try {
            Parent page = FXMLLoader.load(getClass().getResource("/view/" + fxml));
            contentArea.getChildren().setAll(page);

            AnchorPane.setTopAnchor(page, 0.0);
            AnchorPane.setRightAnchor(page, 0.0);
            AnchorPane.setBottomAnchor(page, 0.0);
            AnchorPane.setLeftAnchor(page, 0.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
