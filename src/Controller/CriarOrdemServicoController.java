package Controller;

import DB.ClienteDAO;
import DB.PecaDAO;
import Model.*;
import Templates.Alertas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        comboCliente.setItems(ClienteDAO.listarClientes());
        configurarComboCliente();


        // comboPeca.setItems(PecaDAO.listarPecas());

        comboStatus.setItems(FXCollections.observableArrayList(
                "Em Serviço", "Aguardando Peças", "Pronto para Entrega", "Finalizado"
        ));
        comboStatus.setValue("Em Serviço");

        colPecaNome.setCellValueFactory(data -> data.getValue().nomePecaProperty());
        colPecaQtd.setCellValueFactory(data -> data.getValue().quantidadeProperty());
        colPecaPreco.setCellValueFactory(data -> data.getValue().precoUnitarioProperty());
        colPecaTotal.setCellValueFactory(data -> data.getValue().totalProperty());
        tabelaPecas.setItems(pecasAdicionadas);
    }

    private void configurarComboCliente() {
        comboCliente.setButtonCell(new ListCell<Cliente>() {
            @Override
            protected void updateItem(Cliente item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getNome());
            }
        });
        comboCliente.setCellFactory(lv -> new ListCell<Cliente>() {
            @Override
            protected void updateItem(Cliente item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getNome() + " - CPF: " + item.getCpf());
            }
        });
    }

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
