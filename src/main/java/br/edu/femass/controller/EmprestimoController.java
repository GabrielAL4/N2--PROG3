package br.edu.femass.controller;

import br.edu.femass.dao.DaoEmprestimo;
import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoLeitor;
import br.edu.femass.model.Emprestimo;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Leitor;
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

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class EmprestimoController implements Initializable {
    @FXML
    private ComboBox<Leitor> comboLeitor;
    @FXML
    private ComboBox<Exemplar> comboExemplar;
    @FXML
    private Button includeButton;
    @FXML
    private Button modifyButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button addEmprestimoButton;
    @FXML
    private TableView<Emprestimo> tableEmprestimos = new TableView<Emprestimo>();
    @FXML
    private TableColumn<Emprestimo,Long> columnId = new TableColumn<>();
    @FXML
    private TableColumn<Exemplar,String> columnExemplar = new TableColumn<>();
    @FXML
    private TableColumn<Leitor, String> columnLeitor = new TableColumn<>();

    private DaoEmprestimo dao = new DaoEmprestimo();
    private DaoExemplar daoExemplar = new DaoExemplar();
    private DaoLeitor daoLeitor = new DaoLeitor();

    Emprestimo emprestimo = new Emprestimo();
    private Boolean including;
    Exemplar exemplar;

    @FXML
    private void adicionar_emprestimo(ActionEvent event) {
        exemplar = comboExemplar.getSelectionModel().getSelectedItem();
        exemplar.setDisponivel(false);
        emprestimo.setExemplar(exemplar);
        emprestimo.setLeitor(comboLeitor.getSelectionModel().getSelectedItem());
        emprestimo.setDataEmprestimo();
        emprestimo.setDataPrevistaDevolucao();

        if(including){
            dao.insert(emprestimo);
        }else{
            dao.modify(emprestimo);
        }
        fillTable();

        editar(false);
    }
    
    @FXML
    private void incluir_emprestimo(ActionEvent event){
        editar(true);
        fillLeitorCombo();
        fillExemplarCombo();
        fillTable();
        including = true;
        emprestimo = new Emprestimo();
    }

    @FXML
    private void alterar_emprestimo(ActionEvent event){
        emprestimo = tableEmprestimos.getSelectionModel().getSelectedItem();
        editar(true);
        exemplar = emprestimo.getExemplar();
        exemplar.setDisponivel(true);
        fillTable();
        fillLeitorCombo();
        fillExemplarCombo();
        including = false;
    }

    @FXML
    private void excluir_emprestimo(ActionEvent event){
        emprestimo = tableEmprestimos.getSelectionModel().getSelectedItem();
        exemplar = emprestimo.getExemplar();
        exemplar.setDisponivel(true);

        dao.delete(emprestimo);
        tableEmprestimos.refresh();
    }

    private void editar(boolean enable){
        comboLeitor.setDisable(!enable);
        comboExemplar.setDisable(!enable);
        modifyButton.setDisable(enable);
        addEmprestimoButton.setDisable(!enable);
        deleteButton.setDisable(enable);
        includeButton.setDisable(enable);
    }

    private void fillTable(){
        List<Emprestimo> emprestimos = dao.searchAll();

        ObservableList<Emprestimo> data = FXCollections.observableArrayList(emprestimos);
        tableEmprestimos.setItems(data);
        tableEmprestimos.refresh();
    }

    private void fillExemplarCombo(){
        List<Exemplar> exemplares = daoExemplar.searchAvaible();

        ObservableList<Exemplar> data = FXCollections.observableArrayList(exemplares);
        comboExemplar.setItems(data);
    }

    private void fillLeitorCombo(){
        List<Leitor> leitores = daoLeitor.searchAll();

        ObservableList<Leitor> data = FXCollections.observableArrayList(leitores);
        comboLeitor.setItems(data);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        columnId.setCellValueFactory(
                new PropertyValueFactory<Emprestimo, Long>("id")
        );

        columnLeitor.setCellValueFactory(
                new PropertyValueFactory<Leitor, String>("leitor")
        );

        columnExemplar.setCellValueFactory(
                new PropertyValueFactory<Exemplar, String>("exemplar")
        );

        fillExemplarCombo();
        fillLeitorCombo();
        fillTable();

        editar(false);
    }
}