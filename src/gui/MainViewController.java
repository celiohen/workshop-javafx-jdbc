/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

/**
 *
 * @author celio
 */
public class MainViewController implements Initializable{
    
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
        System.out.println("onMenuDepartmentAction");
    }
    
    @FXML
    public void onMenuItemAboutAction() {
        System.out.println("onMenuAboutAction");
    }

    @Override
    public void initialize(URL uri, ResourceBundle rb) {
        
    }
    
}
