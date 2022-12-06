package br.edu.femass.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.model.Aluno;
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

public class AlunoController implements Initializable{
    @FXML
    private TextField txtMatricula;
    
    private DaoAluno dao = new DaoAluno();
    
    private Aluno aluno;

    private Boolean including;


    @FXML
    private Button saveButton;

    @FXML
    private ListView<Aluno> lstAlunos;
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
    private Button addButton;

    @FXML
    private void salvar_aluno(ActionEvent event) {

        aluno.setNome(txtNome.getText());
        aluno.setMatricula(txtMatricula.getText());
        aluno.setEndereco(txtEndereco.getText());
        aluno.setTelefone(txtTelefone.getText());

        if (including) {
            dao.insert(aluno);
        } else {
            dao.modify(aluno);
        }
        
        fillList();
        edit(false);
    }

    @FXML
    private void incluir_aluno(ActionEvent event) {
        edit(true);
        including = true;
        aluno = new Aluno();
        txtNome.setText("");
        txtEndereco.setText("");
        txtMatricula.setText("");
        txtTelefone.setText("");
        txtNome.requestFocus();
    }

    @FXML
    private void alterar_aluno(ActionEvent event) {
        edit(true);
        including = false;
    }
    
    @FXML
    private void excluir_aluno(ActionEvent event) {
        dao.delete(aluno);
        fillList();
    }

    @FXML
    private void lstalunos_KeyPressed(KeyEvent event){
        showData();
    }
    
    @FXML
    private void lstalunos_MouseClicked(MouseEvent event){
        showData();
    }

    private void edit(boolean enable){
        lstAlunos.setDisable(enable);
        txtNome.setDisable(!enable);
        txtEndereco.setDisable(!enable);
        txtMatricula.setDisable(!enable);
        txtTelefone.setDisable(!enable);
        addButton.setDisable(!enable);
        includeButton.setDisable(enable);
        modifyButton.setDisable(enable);
        deleteButton.setDisable(enable);
    }
    private void showData(){
        this.aluno = lstAlunos.getSelectionModel().getSelectedItem();

        if(aluno == null) return;

        txtNome.setText(aluno.getNome());
        txtEndereco.setText(aluno.getEndereco());
        txtMatricula.setText(aluno.getMatricula());
        txtTelefone.setText(aluno.getTelefone());
    }

    private void fillList(){
        List<Aluno> alunos = dao.searchAll();

        ObservableList<Aluno> data = FXCollections.observableArrayList(alunos);
 
        lstAlunos.setItems(data);
 
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        fillList();
    }
}