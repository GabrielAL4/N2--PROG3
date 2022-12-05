package br.edu.femass.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController implements Initializable{

    @FXML
    private void bibliotecario_click(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Bibliotecario.fxml"));
            
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            scene.getRoot().setStyle("-fx-font-family: 'serif'");
    
            Stage stage = new Stage();
            stage.setTitle("Bibliotecario");
            stage.setScene(scene);
            stage.show();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }
    @FXML
    private void atendente_click(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Atendente.fxml"));
            
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            scene.getRoot().setStyle("-fx-font-family: 'serif'");
    
            Stage stage = new Stage();
            stage.setTitle("Atendente");
            stage.setScene(scene);
            stage.show();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
    }
    
    
}
