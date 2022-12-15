package br.edu.femass.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.DaoProfessor;
import br.edu.femass.model.Professor;
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

public class ProfessorController implements Initializable{
    @FXML
    private TextField txtDisciplina;
    
    private DaoProfessor dao = new DaoProfessor();
    
    private Professor professor;

    private Boolean including;


    @FXML
    private Button saveButton;

    @FXML
    private ListView<Professor> lstProfessores;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtEndereco;
    @FXML
    private TextField txtTelefone;

    @FXML
    private Button includeButton;
    @FXML
    private Button modifyButton;
    @FXML
    private Button deleteButton;


    @FXML
    private void salvar_professor(ActionEvent event) {

        professor.setNome(txtNome.getText());
        professor.setDisciplina(txtDisciplina.getText());
        professor.setEndereco(txtEndereco.getText());
        professor.setTelefone(txtTelefone.getAccessibleText());

        if (including) {
            dao.insert(professor);
        } else {
            dao.modify(professor);
        }
        
        fillList();
        edit(false);
    }

    @FXML
    private void incluir_professor(ActionEvent event) {
        edit(true);
        including = true;
        professor = new Professor();
        txtNome.setText("");
        txtEndereco.setText("");
        txtDisciplina.setText("");
        txtTelefone.setText("");
        txtDisciplina.requestFocus();
    }

    @FXML
    private void alterar_professor(ActionEvent event) {
        edit(true);
        including = false;
    }
    
    @FXML
    private void excluir_professor(ActionEvent event) {
        dao.delete(professor);
        fillList();
    }

    @FXML
    private void lstprofessores_KeyPressed(KeyEvent event){
        showData();
    }
    
    @FXML
    private void lstprofessores_MouseClicked(MouseEvent event){
        showData();
    }

    private void edit(boolean enable){
        lstProfessores.setDisable(enable);
        txtNome.setDisable(!enable);
        txtEndereco.setDisable(!enable);
        txtDisciplina.setDisable(!enable);
        txtTelefone.setDisable(!enable);
        saveButton.setDisable(!enable);
        includeButton.setDisable(enable);
        modifyButton.setDisable(enable);
        deleteButton.setDisable(enable);
    }
    private void showData(){
        this.professor = lstProfessores.getSelectionModel().getSelectedItem();

        if(professor == null) return;

        txtNome.setText(professor.getNome());
        txtEndereco.setText(professor.getEndereco());
        txtDisciplina.setText(professor.getDisciplina());
        txtTelefone.setText(professor.getTelefone());
    }

    private void fillList(){
        List<Professor> professores = dao.searchAll();

        ObservableList<Professor> data = FXCollections.observableArrayList(professores);
 
        lstProfessores.setItems(data);
 
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        fillList();
    }
}