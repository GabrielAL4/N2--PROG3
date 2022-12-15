package br.edu.femass.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Livro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import net.bytebuddy.asm.Advice.Local;


public class ExemplarController implements Initializable {
    @FXML
    private TableView<Exemplar> exemplarTable = new TableView<Exemplar>(); 

    @FXML
    private TableColumn<Exemplar,Long> columnId = new TableColumn<>();

    @FXML
    private TableColumn<Livro,String> columnLivro = new TableColumn<>();

    @FXML
    private TableColumn<Exemplar,LocalDate> columnData = new TableColumn<>();

    @FXML
    private Button incluirExButton;
  
    @FXML
    private Button modifyExButton;

    @FXML
    private Button deleteExButton;

    @FXML
    private Button addExemplarButton; 

    @FXML
    private ComboBox<Livro> comboBoxLivros;

    private DaoExemplar dao = new DaoExemplar();
    private DaoLivro daoLivro = new DaoLivro();
    
    private Livro livro;
    private Exemplar exemplar;
    private Boolean including;

    @FXML
    private void adicionar_exemplar(ActionEvent event) {
        exemplar.setLivro(comboBoxLivros.getSelectionModel().getSelectedItem());
        if (including) {
            dao.insert(exemplar);
        } else {
            dao.modify(exemplar);
        }

        fillTable();
        editar(false);
        
    }

    @FXML
    private void incluir_exemplar(ActionEvent event) {
        editar(true);
        fillCombo();
        fillTable();
        including = true;

        exemplar = new Exemplar();
        comboBoxLivros.requestFocus();
    }

    @FXML
    private void alterar_click(ActionEvent event) {
        editar(true);
        fillCombo();
        fillTable();
        including = false;
    }

    @FXML
    private void excluir_click(ActionEvent event) {
        dao.delete(exemplar);

        fillTable();
    }
    
    private void editar(boolean enable) {
        comboBoxLivros.setDisable(!enable);
        addExemplarButton.setDisable(!enable);
        modifyExButton.setDisable(enable);
        incluirExButton.setDisable(enable);
        deleteExButton.setDisable(enable);
    }

    private void fillTable(){
        List<Exemplar> exemplares = dao.searchAll();
        ObservableList<Exemplar> data = FXCollections.observableArrayList(exemplares);
        exemplarTable.setItems(data);
        exemplarTable.refresh();   
    }

    private void fillCombo(){
        List<Livro> livros = daoLivro.searchAll();

        ObservableList<Livro> data = FXCollections.observableArrayList(livros);
        comboBoxLivros.setItems(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnId.setCellValueFactory(
            new PropertyValueFactory<Exemplar,Long>("id")
        );

        columnLivro.setCellValueFactory(
            new PropertyValueFactory<Livro,String>("livro")
        );

        columnData.setCellValueFactory(
            new PropertyValueFactory<Exemplar,LocalDate>("dataAquisicao")
        );

        fillCombo();
        fillTable();
    }    
}