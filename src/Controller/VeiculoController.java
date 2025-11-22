package Controller;

import Model.MudarTela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class VeiculoController {

    @FXML
    private TableColumn<?, ?> colAno;

    @FXML
    private TableColumn<?, ?> colCliente;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colModelo;

    @FXML
    private TableColumn<?, ?> colPlaca;

    @FXML
    private Label lblUsuario;

    @FXML
    private TableView<?> tabelaVeiculos;

    @FXML
    void excluirVeiculo(ActionEvent event) {

    }

    @FXML
    void verHistorico(ActionEvent event) {

    }

    @FXML
    void irParaAdicionar(ActionEvent event) throws IOException {
        MudarTela.trocarJanela(event, "/View/AdicionarVeiculo.fxml");
    }

    @FXML
    void irParaEditar(ActionEvent event) {

    }

    @FXML
    void irParaOrdens(ActionEvent event) {

    }

    @FXML
    void irParaPecas(ActionEvent event) {

    }

    @FXML
    void irParaRelatorios(ActionEvent event) {

    }

    @FXML
    void irParaAgendamentos(ActionEvent event) {

    }

    @FXML
    void voltarParaPainel(ActionEvent event) throws IOException {
        MudarTela.trocarJanela(event, "/View/PainelAdministrativo.fxml");
    }


}
