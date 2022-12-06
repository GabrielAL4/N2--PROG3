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

public class BibliotecarioController implements Initializable{

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
    }

    @FXML
    private void autor_menu(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Autor.fxml"));
            
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            scene.getRoot().setStyle("-fx-font-family: 'serif'");
    
            Stage stage = new Stage();
            stage.setTitle("Autor");
            stage.setScene(scene);
            stage.show();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }

    @FXML
    private void livro_menu(ActionEvent event){}

    @FXML
    private void leitor_menu(ActionEvent event){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Leitor.fxml"));
                
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            scene.getRoot().setStyle("-fx-font-family: 'serif'");

            Stage stage = new Stage();
            stage.setTitle("Leitor");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @FXML
    private void emprestimo_menu(ActionEvent event){}


    

}