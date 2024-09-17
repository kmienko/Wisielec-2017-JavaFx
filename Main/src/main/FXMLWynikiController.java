/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FXMLWynikiController implements Initializable {
        
@FXML TableView<UserDetails> tview;
@FXML TableColumn<UserDetails,String> imie_kol;
@FXML TableColumn<UserDetails,String> hasło_kol;
@FXML TableColumn<UserDetails,String> błędy_kol;
private ObservableList<UserDetails> data;     
public final String DB_NAME = "XE";
    public final String DB_USER = "SYSTEM";
    public final String DB_PASS = "kamil123";
    Connection conn = null;
    public boolean openConnection(){
        boolean result;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            

            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:"+DB_NAME+"",DB_USER,DB_PASS);

            if (conn != null){
                System.out.println("CONNECTION DONE");
            }
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        return result;
        
    }          
    
    @FXML
    private void doMenu(ActionEvent event)throws IOException {
        System.out.println("menu");
        Parent menu_parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene menu_scene = new Scene(menu_parent);
        Stage ekranmenu = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ekranmenu.setScene(menu_scene);
        ekranmenu.show();
    }
    //////////////////////////////////////////////////////////////////////////////////////
       

    @FXML private void doZaładuj(ActionEvent event) throws IOException, SQLException {
    //tutej łądujesz 
    openConnection();
    data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM aaaWYNIKI");
            while (rs.next()) {
                //get string from db,whichever way 
                data.add(new UserDetails(rs.getString(1), rs.getString(2), rs.getString(3)));
            }

       
        
        //Set cell value factory to tableview.
        //NB.PropertyValue Factory must be the same with the one set in model class.
        imie_kol.setCellValueFactory(new PropertyValueFactory<>("name"));
        hasło_kol.setCellValueFactory(new PropertyValueFactory<>("email"));
        błędy_kol.setCellValueFactory(new PropertyValueFactory<>("department"));
        
        tview.setItems(data);
           conn.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
