/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;



import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.image.ImageView;


import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FXMLGrajController implements Initializable {
  
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
    
    @FXML private ImageView Pion;
    @FXML private ImageView klata;
    @FXML private ImageView noga2_koniec;
    @FXML private ImageView noga1;@FXML private ImageView Róg;
    @FXML private ImageView Poziom;
    @FXML private ImageView głowa;
    @FXML private ImageView ręka2;
    @FXML private ImageView ręka1; @FXML private ImageView Sznur;
    
    @FXML private Label komunikat;
    
    @FXML private Label błąd_licznik;
    @FXML
    private Button A;
    @FXML
    private Button B;
    @FXML
    private Button C;
    @FXML
    private Button D;
    @FXML
    private Button E;
    @FXML
    private Button F;
    @FXML
    private Button G;
    @FXML
    private Button H;
    @FXML
    private Button I;
    @FXML
    private Button J;
    @FXML
    private Button K;
    @FXML
    private Button L;
    @FXML
    private Button M;
    @FXML
    private Button N;
    @FXML
    private Button O;
    @FXML
    private Button P;
    @FXML
    private Button R;
    @FXML
    private Button S;
    @FXML
    private Button T;
    @FXML
    private Button U;
    @FXML
    private Button W;
    @FXML
    private Button Y;
    @FXML
    private Button Z;
    
    
    @FXML
    private Button zatwierdz;
    @FXML
    private TextField imietf;
    @FXML
    private Label haslo_gra;
    @FXML
    private PasswordField haslopf;
    String haslo,haslo_kopia;
    char typy[];
    String filtr = " ";
    int zle=0;
    
    private void obsługaPrzycisków_start(){
        zatwierdz.setDisable(true);
       
        ///calo klawa
        A.setDisable(false);G.setDisable(false);M.setDisable(false);T.setDisable(false);
        B.setDisable(false);H.setDisable(false);N.setDisable(false);U.setDisable(false);
        C.setDisable(false);I.setDisable(false);O.setDisable(false);W.setDisable(false);
        D.setDisable(false);J.setDisable(false);P.setDisable(false);Y.setDisable(false);
        E.setDisable(false);K.setDisable(false);R.setDisable(false);Z.setDisable(false);
        F.setDisable(false);L.setDisable(false);S.setDisable(false);
       Pion.setVisible(false);ręka1.setVisible(false);Poziom.setVisible(false);
       noga1.setVisible(false);ręka2.setVisible(false);klata.setVisible(false);
       noga2_koniec.setVisible(false);Róg.setVisible(false);Sznur.setVisible(false);
        głowa.setVisible(false);
        komunikat.setVisible(false);
    }
     private void obsługaPrzycisków_koniec(){
        zatwierdz.setDisable(false);
       
        ///calo klawa
        A.setDisable(true);G.setDisable(true);M.setDisable(true);T.setDisable(true);
        B.setDisable(true);H.setDisable(true);N.setDisable(true);U.setDisable(true);
        C.setDisable(true);I.setDisable(true);O.setDisable(true);W.setDisable(true);
        D.setDisable(true);J.setDisable(true);P.setDisable(true);Y.setDisable(true);
        E.setDisable(true);K.setDisable(true);R.setDisable(true);Z.setDisable(true);
        F.setDisable(true);L.setDisable(true);S.setDisable(true);
    
        haslopf.clear();
        imietf.clear();
        
        komunikat.setVisible(true);
        
        
    }
    @FXML
    private void doMenu(ActionEvent event) throws IOException, SQLException {
        System.out.println("menu");
        Parent menu_parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene menu_scene = new Scene(menu_parent);
        Stage ekranmenu = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ekranmenu.setScene(menu_scene);
        ekranmenu.show();
        
        


    }
    
    @FXML
    private void doZatwierdz(ActionEvent event) throws IOException {
       
        String imie_s = imietf.getText();
        //    if(!imie_s.isEmpty())
        haslo = haslopf.getText();
        // if(!haslo.isEmpty()){
     //   typy = haslo.toCharArray();
     
        haslo_gra.setText(haslo.replaceAll("[^" + filtr + "]", "_"));
        haslo_kopia=haslo;
        obsługaPrzycisków_start();
        
        // System.out.println("zatwierdz");
        // }

        // haslo_gra.setText("Wypełnij pola!");
    }//

    @FXML
    private void doA(ActionEvent event) throws IOException, SQLException {
        Button ten = A;
        ten.setDisable(true);
        filtr = filtr + "Aa";
        testlitery();
    }
    @FXML
    private void doB(ActionEvent event) throws IOException, SQLException {
        Button ten = B;
        ten.setDisable(true);
        filtr = filtr + "Bb";
        testlitery();
    }
    @FXML
    private void doC(ActionEvent event) throws IOException, SQLException {
        Button ten = C;
        ten.setDisable(true);
        filtr = filtr + "Cc";
        testlitery();
    }
    @FXML
    private void doD(ActionEvent event) throws IOException, SQLException {
        Button ten = D;
        ten.setDisable(true);
        filtr = filtr + "Dd";
        testlitery();
    }
    @FXML
    private void doE(ActionEvent event) throws IOException, SQLException {
        Button ten = E;
        ten.setDisable(true);
        filtr = filtr + "Ee";
       testlitery();
    }
    @FXML
    private void doF(ActionEvent event) throws IOException, SQLException {
        Button ten = F;
        ten.setDisable(true);
        filtr = filtr + "Ff";
        testlitery();
    }
    @FXML
    private void doG(ActionEvent event) throws IOException, SQLException {
        Button ten = G;
        ten.setDisable(true);
        filtr = filtr + "Gg";
        testlitery();
    }
    @FXML
    private void doH(ActionEvent event) throws IOException, SQLException {
        Button ten = H;
        ten.setDisable(true);
        filtr = filtr + "Hh";
        testlitery();
    }
    @FXML
    private void doI(ActionEvent event) throws IOException, SQLException {
        Button ten = I;
        ten.setDisable(true);
        filtr = filtr + "Ii";
       testlitery();
    }
    @FXML
    private void doJ(ActionEvent event) throws IOException, SQLException {
        Button ten = J;
        ten.setDisable(true);
        filtr = filtr + "Jj";
        testlitery();
    }
    @FXML
    private void doK(ActionEvent event) throws IOException, SQLException {
        Button ten = K;
        ten.setDisable(true);
        filtr = filtr + "Kk";
        testlitery();
    }
    @FXML
    private void doL(ActionEvent event) throws IOException, SQLException {
        Button ten = L;
        ten.setDisable(true);
        filtr = filtr + "Ll";
        testlitery();
    }
    @FXML
    private void doM(ActionEvent event) throws IOException, SQLException {
        Button ten = M;
        ten.setDisable(true);
        filtr = filtr + "Mm";
        testlitery();
    }
    @FXML
    private void doN(ActionEvent event) throws IOException, SQLException {
        Button ten = N;
        ten.setDisable(true);
        filtr = filtr + "Nn";
        testlitery();
    }
    @FXML
    private void doO(ActionEvent event) throws IOException, SQLException {
        Button ten = O;
        ten.setDisable(true);
        filtr = filtr + "Oo";
        testlitery();
    }
    @FXML
    private void doP(ActionEvent event) throws IOException, SQLException {
        Button ten = P;
        ten.setDisable(true);
        filtr = filtr + "Pp";
        testlitery();
    }
    @FXML
    private void doR(ActionEvent event) throws IOException, SQLException {
        Button ten = R;
        ten.setDisable(true);
        filtr = filtr + "Rr";
        testlitery();
    }
    @FXML
    private void doS(ActionEvent event) throws IOException, SQLException {
        Button ten = S;
        ten.setDisable(true);
        filtr = filtr + "Ss";
        testlitery();
    }
    @FXML
    private void doT(ActionEvent event) throws IOException, SQLException {
        Button ten = T;
        ten.setDisable(true);
        filtr = filtr + "Tt";
        testlitery();
    }
    @FXML
    private void doU(ActionEvent event) throws IOException, SQLException {
        Button ten = U;
        ten.setDisable(true);
        filtr = filtr + "Uu";
        testlitery();
    }
    @FXML
    private void doW(ActionEvent event) throws IOException, SQLException {
        Button ten = W;
        ten.setDisable(true);
        filtr = filtr + "Ww";
        testlitery();
    }
    @FXML
    private void doY(ActionEvent event) throws IOException, SQLException {
        Button ten = Y;
        ten.setDisable(true);
        filtr = filtr + "Yy";
        testlitery();
    }
    @FXML
    private void doZ(ActionEvent event) throws IOException, SQLException {
        Button ten = Z;
        ten.setDisable(true);
        filtr = filtr + "Zz";
        testlitery();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }
    public void testlitery() throws SQLException {
        haslo_kopia=haslo_gra.getText();
        haslo_gra.setText(haslo.replaceAll("[^" + filtr + "]", "_"));
        if(haslo_gra.getText().contentEquals(haslo_kopia)){
        błąd_licznik.setText("Brak litery: "+ Integer.toString(++zle) );
        Pion.setVisible(true);
        if(zle==2)
            Róg.setVisible(true);
        else if(zle==3)
            Poziom.setVisible(true);
        else if(zle==4)
            Sznur.setVisible(true);
        else if(zle==5)
            głowa.setVisible(true);
        else if(zle==6)
            klata.setVisible(true);
        else if(zle==7)
            ręka1.setVisible(true);
        else if(zle==8)
            ręka2.setVisible(true);
        else if(zle==9)
            noga1.setVisible(true);
        else if(zle==10){
            noga2_koniec.setVisible(true);
            obsługaPrzycisków_koniec();
            komunikat.setText("Przegrałeś!");
        haslo_gra.setText("Hasło:");
        }
        }//koniec ifa sprawdzajacego zle
        else if(!haslo_gra.getText().contains("_")){
           
            komunikat.setText("Wygrałeś!");
            //tutaj daj wynik do bazy danych
           
            openConnection();
           String imie_dbwart = "'" + imietf.getText() + "'";
           String licznik_dbwart ="'" +  Integer.toString(zle)+ "'";
           String haslo_dbwart = "'" + haslo_gra.getText()+ "'";
            
           Statement  stmt = conn.createStatement();
      
     
     String sql = "INSERT INTO aaawyniki"
             + "(imie_db, hasło_db,licznik_db)"
             + "Values("+imie_dbwart+","+haslo_dbwart+","+licznik_dbwart+")";
            
       stmt.executeUpdate(sql);
      
      System.out.println("Inserted records into the table...");
            conn.close();
             obsługaPrzycisków_koniec();
            
            
            
            
            
            
        }
    };
    /* final EventHandler<ActionEvent> myHandler = new EventHandler<ActionEvent>(){

    @Override
    public void handle(final ActionEvent event) {
        Button ez = (Button) event.getSource();
        ez.setDisable(true);
    }
};   
     */
}//class
