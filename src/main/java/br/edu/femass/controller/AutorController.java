package br.edu.femass.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.model.Autor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    @FXML
    private TableView<Autor> tableAutores = new TableView<Autor>();
    @FXML
    private TableColumn<Autor, Long> columnId = new TableColumn<>();
    @FXML
    private TableColumn<Autor, String> columnNome = new TableColumn<>();
    @FXML
    private TableColumn<Autor, String> columnSobrenome = new TableColumn<>();
    @FXML
    private TableColumn<Autor, String> columnNacionalidade = new TableColumn<>();


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
        fillTable();
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
        fillTable();
    }

    @FXML
    private void lstAutores_KeyPressed(KeyEvent event){
        showData();
    }
    
    @FXML
    private void lstAutores_MouseClicked(MouseEvent event){
        showData();
    }

    @FXML
    private void tableAutores_KeyPressed(KeyEvent event){
        showData();
    }
    
    @FXML
    private void tableAutores_MouseClicked(MouseEvent event){
        showData();
    }

    private void edit(boolean enable){
        lstAutores.setDisable(enable);
        tableAutores.setDisable(enable);
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
        this.autor = tableAutores.getSelectionModel().getSelectedItem();
        
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

    private void fillTable(){
        List<Autor> autores = dao.searchAll();

        ObservableList<Autor> data = FXCollections.observableArrayList(autores);
 
        tableAutores.setItems(data);
        tableAutores.refresh();

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnId.setCellValueFactory(
            new PropertyValueFactory<Autor, Long>("id")
        );
        columnNome.setCellValueFactory(
            new PropertyValueFactory<Autor, String>("nome")
        );
        columnSobrenome.setCellValueFactory(
            new PropertyValueFactory<Autor, String>("sobrenome")
        );
        columnNacionalidade.setCellValueFactory(
            new PropertyValueFactory<Autor, String>("nacionalidade")
        );
        
        tableAutores.refresh();
        fillList();
        fillTable();
    }
}