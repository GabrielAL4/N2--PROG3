package br.edu.femass.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Livro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class LivroController implements Initializable{

    @FXML
    private ListView<Livro> lstLivros;
    @FXML
    private TextField txtTitulo;
    @FXML
    private ComboBox<Autor> autorComboBox;
    @FXML
    private Button addButton;
    @FXML
    private Button includeButton;
    @FXML
    private Button modifyButton;
    @FXML
    private Button deleteButton;

    private Livro livro;
    private Boolean including;
    private DaoLivro dao = new DaoLivro();
    @FXML
    private void salvar_livro(ActionEvent event) {

        Autor autor = autorComboBox.getSelectionModel().getSelectedItem();

        livro.setTitulo(txtTitulo.getText());
        livro.setAutor(autor);
        if (including) {
            dao.insert(livro);
        } else {
            dao.modify(livro);
        }
        
        fillList();
        edit(false);
    }

    @FXML
    private void incluir_livro(ActionEvent event) {
        edit(true);
        including = true;
        livro = new Livro();

        txtTitulo.setText("");
        autorComboBox.setValue(null);
        txtTitulo.requestFocus();
    }

    @FXML
    private void alterar_livro(ActionEvent event) {
        edit(true);
        including = false;
    }
    
    @FXML
    private void excluir_livro(ActionEvent event) {
        dao.delete(livro);
        fillList();
    }

    @FXML
    private void lstLivros_KeyPressed(KeyEvent event){
        showData();
    }
    
    @FXML
    private void lstLivros_MouseClicked(MouseEvent event){
        showData();
    }

    private void edit(boolean enable){
        lstLivros.setDisable(enable);
        txtTitulo.setDisable(!enable);
        autorComboBox.setDisable(!enable);
        addButton.setDisable(!enable);
        includeButton.setDisable(enable);
        modifyButton.setDisable(enable);
        deleteButton.setDisable(enable);
    }
    private void showData(){
        this.livro = lstLivros.getSelectionModel().getSelectedItem();

        if(livro == null) return;

        txtTitulo.setText(livro.getTitulo());
        autorComboBox.setValue(livro.getAutor());
     
    }

    private void fillList(){
        List<Livro> livros = dao.searchAll();

        ObservableList<Livro> data = FXCollections.observableArrayList(livros);
 
        lstLivros.setItems(data);
 
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        fillList();
    }
    
}
