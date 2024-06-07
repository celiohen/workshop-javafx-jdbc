/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import application.Main;
import gui.util.Alerts;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.services.DepartmentService;

/**
 *
 * @author celio
 */
public class MainViewController implements Initializable {

    @FXML
    private MenuItem menuItemSeller;

    @FXML
    private MenuItem menuItemDepartment;

    @FXML
    private MenuItem menuItemAbout;

    @FXML
    public void onMenuItemSellerAction() {
        System.out.println("onMenuSellerAction");
    }

    @FXML
    public void onMenuItemDepartmentAction() {
        loadView2("/gui/Department.fxml");
    }

    @FXML
    public void onMenuItemAboutAction() {
        loadView("/gui/About.fxml");
    }

    @Override
    public void initialize(URL uri, ResourceBundle rb) {

    }
    
//    private void loadView(String absoluteName) {
//    try {
//        URL url = getClass().getResource(absoluteName);
//        if (url == null) {
//            Alerts.showAlert("File Not Found", "Error loading view", "Resource file not found: " + absoluteName, Alert.AlertType.ERROR);
//            return;
//        }
//
//        FXMLLoader loader = new FXMLLoader(url);
//        VBox newVBox = loader.load();
//
//        Scene mainScene = Main.getMainScene();
//        if (mainScene == null) {
//            Alerts.showAlert("Null Pointer Exception", "Error loading view", "Main scene is null", Alert.AlertType.ERROR);
//            return;
//        }
//
//        if (!(mainScene.getRoot() instanceof ScrollPane)) {
//            Alerts.showAlert("Class Cast Exception", "Error loading view", "Root is not an instance of ScrollPane", Alert.AlertType.ERROR);
//            return;
//        }
//
//        VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
//        if (mainVBox == null) {
//            Alerts.showAlert("Null Pointer Exception", "Error loading view", "Main VBox is null", Alert.AlertType.ERROR);
//            return;
//        }
//
//        if (mainVBox.getChildren().isEmpty()) {
//            Alerts.showAlert("Index Out Of Bounds Exception", "Error loading view", "Main VBox has no children", Alert.AlertType.ERROR);
//            return;
//        }
//
//        Node mainMenu = mainVBox.getChildren().get(0);
//        mainVBox.getChildren().clear();
//        mainVBox.getChildren().add(mainMenu);
//        mainVBox.getChildren().addAll(newVBox.getChildren());
//    } catch (IOException e) {
//        Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), Alert.AlertType.ERROR);
//    }}



    private void loadView(String absoluteName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            VBox newVBox = loader.load();

            Scene mainScene = Main.getMainScene();
            VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

            Node mainMenu = mainVBox.getChildren().get(0);
            mainVBox.getChildren().clear();
            mainVBox.getChildren().add(mainMenu);
            mainVBox.getChildren().addAll(newVBox.getChildren());
            
            
        } catch (IOException e) {
            Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), Alert.AlertType.ERROR);
        } catch (NullPointerException e) {
            Alerts.showAlert("Null Pointer Exception", "Error loading view", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    private void loadView2(String absoluteName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            VBox newVBox = loader.load();

            Scene mainScene = Main.getMainScene();
            VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

            Node mainMenu = mainVBox.getChildren().get(0);
            mainVBox.getChildren().clear();
            mainVBox.getChildren().add(mainMenu);
            mainVBox.getChildren().addAll(newVBox.getChildren());
            
            DepartmentListController controller = loader.getController();
            controller.setDepartmentService(new DepartmentService());
            controller.updateTableView();
        } catch (IOException e) {
            Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), Alert.AlertType.ERROR);
        } catch (NullPointerException e) {
            Alerts.showAlert("Null Pointer Exception", "Error loading view", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}
