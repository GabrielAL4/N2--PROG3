package br.edu.femass.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.Dao;
import br.edu.femass.dao.DaoAutor;
import br.edu.femass.model.Autor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class AutorController implements Initializable {
    
    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtSobrenome;

    @FXML
    private TextField txtNacionalidade;

    @FXML
    private ListView<Autor> lstAutores;

    private Autor autor;

    private DaoAutor dao = new DaoAutor();

    private Boolean including;
    
    @FXML
    private Button includeButton;
    @FXML
    private Button modifyButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button addButton;

    @FXML
    private void adicionar_autor(ActionEvent event) {

        autor.setNome(txtNome.getText());
        autor.setSobrenome(txtSobrenome.getText());
        autor.setNacionalidade(txtNacionalidade.getText());

        if (including) {
            dao.insert(autor);
        } else {
            dao.modify(autor);
        }
        
        fillList();
        edit(false);
    }

    @FXML
    private void incluir_autor(ActionEvent event) {
        edit(true);
        including = true;
        autor = new Autor();
        txtNome.setText("");
        txtSobrenome.setText("");
        txtNacionalidade.setText("");
        txtNome.requestFocus();
    }

    @FXML
    private void alterar_autor(ActionEvent event) {
        edit(true);
        including = false;
    }
    
    @FXML
    private void excluir_autor(ActionEvent event) {
        dao.delete(autor);
        fillList();
    }

    @FXML
    private void lstAutores_KeyPressed(KeyEvent event){
        showData();
    }
    
    @FXML
    private void lstAutores_MouseClicked(MouseEvent event){
        showData();
    }

    private void edit(boolean enable){
        lstAutores.setDisable(enable);
        txtNome.setDisable(!enable);
        txtSobrenome.setDisable(!enable);
        txtNacionalidade.setDisable(!enable);
        addButton.setDisable(!enable);
        includeButton.setDisable(enable);
        modifyButton.setDisable(enable);
        deleteButton.setDisable(enable);
    }
    private void showData(){
        this.autor = lstAutores.getSelectionModel().getSelectedItem();

        if(autor == null) return;

        txtNome.setText(autor.getNome());
        txtSobrenome.setText(autor.getSobrenome());
        txtNacionalidade.setText(autor.getNacionalidade());
    }

    private void fillList(){
        List<Autor> autores = dao.searchAll();

        ObservableList<Autor> data = FXCollections.observableArrayList(autores);
 
        lstAutores.setItems(data);
 
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       fillList();
    }    
}