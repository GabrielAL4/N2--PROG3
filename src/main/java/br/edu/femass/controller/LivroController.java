package br.edu.femass.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.DaoAutor;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class LivroController implements Initializable {
    
    @FXML
    private TextField txtTitulo;
    @FXML
    private ListView<Autor> lstAutor;
    @FXML
    private TableView<Livro> tableLivros = new TableView<Livro>();
    @FXML
    private TableColumn<Livro,Long> columnId = new TableColumn<>();
    @FXML
    private TableColumn<Livro,String> columnTitulo = new TableColumn<>();
    @FXML
    private TableColumn<Livro,String> colAno = new TableColumn<>();
    @FXML
    private TableColumn<Autor,String> columnAutor = new TableColumn<>();
    @FXML
    private Button includeButton;
    @FXML
    private Button modifyButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button addButton; 
    @FXML
    private ComboBox<Autor> autorComboBox;

    private DaoLivro dao = new DaoLivro();
    private DaoAutor daoAutor = new DaoAutor();
    private Livro livro;
    private Autor autor;
    private Boolean including;

    @FXML
    private void salvar_livro(ActionEvent event) {
        livro.setTitulo(txtTitulo.getText());
        livro.setAutor(autorComboBox.getSelectionModel().getSelectedItem());
        if (including) {
            dao.insert(livro);
        } else {
            dao.modify(livro);
        }
        fillTable();
        edit(false);     
    }

    @FXML
    private void incluir_livro(ActionEvent event) {
        edit(true);
        fillCombo();
        including = true;
        livro = new Livro();
        txtTitulo.setText("");
        txtTitulo.requestFocus();
    }

    @FXML
    private void alterar_livro(ActionEvent event) {
        edit(true);
        fillCombo();
        including = false;
    }

    @FXML
    private void excluir_livro(ActionEvent event) {
        dao.delete(livro);
        fillTable();
    }
    
    private void edit(boolean enable) {
        txtTitulo.setDisable(!enable);
        autorComboBox.setDisable(!enable);
        tableLivros.setDisable(enable);
        addButton.setDisable(!enable);
        modifyButton.setDisable(enable);
        includeButton.setDisable(enable);
        deleteButton.setDisable(enable);
    }

    @FXML
    private void tableLivro_KeyPressed(KeyEvent event) {
        showData();
    }

    @FXML
    private void tableLivro_MouseClicked(MouseEvent event) {
        showData();
    }

    private void showData(){
        this.livro = tableLivros.getSelectionModel().getSelectedItem();
        
        if(livro==null) return;

        txtTitulo.setText(livro.getTitulo());
    }

    private void fillCombo(){
        List<Autor> autores = daoAutor.searchAll();
        ObservableList<Autor> data = FXCollections.observableArrayList(autores);
        autorComboBox.setItems(data);   
    }

    private void fillTable(){
        List<Livro> livros = dao.searchAll();
        ObservableList<Livro> data = FXCollections.observableArrayList(livros);
        tableLivros.setItems(data); 
        tableLivros.refresh();  
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnId.setCellValueFactory(
            new PropertyValueFactory<Livro,Long>("id")
        );
        columnTitulo.setCellValueFactory(
            new PropertyValueFactory<Livro,String>("titulo")
        );
        columnAutor.setCellValueFactory(
            new PropertyValueFactory<Autor,String>("autor")
        );
        fillCombo();
        fillTable();
    }    
}