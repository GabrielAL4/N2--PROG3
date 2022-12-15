package br.edu.femass.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.DaoLeitor;
import br.edu.femass.model.Leitor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class LeitorController implements Initializable{
    private DaoLeitor dao = new DaoLeitor();
    @FXML
    private	ListView<Leitor> lstLeitores;

    @FXML
    private TableView<Leitor> tableLeitores = new TableView<>();
    @FXML
    private TableColumn<Leitor, Long > columnCodigo = new TableColumn<>();
    @FXML
    private TableColumn<Leitor,String > columnNome = new TableColumn<>();
    @FXML
    private TableColumn<Leitor,String > columnEndereco = new TableColumn<>();
    @FXML
    private void aluno_click(ActionEvent event){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Aluno.fxml"));
                
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            scene.getRoot().setStyle("-fx-font-family: 'serif'");

            Stage stage = new Stage();
            stage.setTitle("Aluno");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void professor_click(ActionEvent event){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Professor.fxml"));
                
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            scene.getRoot().setStyle("-fx-font-family: 'serif'");

            Stage stage = new Stage();
            stage.setTitle("Professor");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void fillTable(){
        List<Leitor> autores = dao.searchAll();
        ObservableList<Leitor> data = FXCollections.observableArrayList(autores);
        tableLeitores.setItems(data);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        columnNome.setCellValueFactory(
            new PropertyValueFactory<Leitor, String>("Nome")
        );
        columnEndereco.setCellValueFactory(
            new PropertyValueFactory<Leitor, String>("Endereço")
        );
        columnCodigo.setCellValueFactory(
            new PropertyValueFactory<Leitor, Long>("Id")
        );
        fillTable();
    }
}