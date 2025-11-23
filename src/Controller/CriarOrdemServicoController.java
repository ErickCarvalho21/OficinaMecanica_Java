package Controller;

import Model.*;
import Templates.Alertas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.text.DecimalFormat;

public class CriarOrdemServicoController {

    @FXML
    private TableColumn<Peca, String> colPecaNome;

    @FXML
    private TableColumn<Peca, String> colPecaPreco;

    @FXML
    private TableColumn<Peca, String> colPecaQtd;

    @FXML
    private TableColumn<Peca, String> colPecaTotal;

    @FXML
    private ComboBox<Cliente> comboCliente;

    @FXML
    private ComboBox<Peca> comboPeca;

    @FXML
    private ComboBox<String> comboStatus;

    @FXML
    private ComboBox<Veiculo> comboVeiculo;

    @FXML
    private Label lblMaoObra;

    @FXML
    private Label lblPecas;

    @FXML
    private Label lblTotal;

    @FXML
    private TableView<Peca> tabelaPecas;

    @FXML
    private TextArea txtDescricao;

    @FXML
    private TextField txtMaoObra;

    @FXML
    private TextField txtQuantidade;

    private ObservableList<ItemPeca> pecasAdicionadas = FXCollections.observableArrayList();
    private Alertas alertas = new Alertas();
    private DecimalFormat df = new DecimalFormat("R$ #,##0.00");

    @FXML
    void adicionarPeca(ActionEvent event) {

    }

    @FXML
    void carregarVeiculos(ActionEvent event) {

    }

    @FXML
    void criarOrdem(ActionEvent event) {

    }

    @FXML
    void removerPeca(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) throws IOException {
        MudarTela.trocarJanela(event, "/View/PainelOrdensServico.fxml");
    }

}
