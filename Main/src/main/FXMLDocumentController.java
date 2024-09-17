/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void przyciskGraj(ActionEvent event)throws IOException {
        System.out.println("graj");
        Parent oknograj_parent = FXMLLoader.load(getClass().getResource("FXMLGraj.fxml"));
        Scene oknograj_scene = new Scene(oknograj_parent);
        Stage ekrangraj = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ekrangraj.setScene(oknograj_scene);
        ekrangraj.show();
        
    }
    
    @FXML
    private void przyciskWyniki(ActionEvent event)throws IOException  {
        System.out.println("wyniki");
        Parent oknowyniki_parent = FXMLLoader.load(getClass().getResource("FXMLWyniki.fxml"));
        Scene oknowyniki_scene = new Scene(oknowyniki_parent);
        Stage ekranwyniki = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ekranwyniki.setScene(oknowyniki_scene);
        ekranwyniki.show();
    
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
