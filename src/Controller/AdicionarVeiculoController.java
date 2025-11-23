package Controller;

import DB.ClienteDAO;
import DB.VeiculoDAO;
import Model.Cliente;
import Model.MudarTela;
import Templates.Alertas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdicionarVeiculoController implements Initializable {

    @FXML
    private TextField txtPlaca;

    @FXML
    private TextField txtModelo;

    @FXML
    private TextField txtAno;

    @FXML
    private ComboBox<Cliente> comboClientes;

    @FXML
    private Label lblMensagem;

    private Alertas alertas = new Alertas();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Carregar clientes no ComboBox
        comboClientes.setItems(ClienteDAO.listarClientes());

        // Configurar como o cliente será exibido no ComboBox
        comboClientes.setButtonCell(new javafx.scene.control.ListCell<Cliente>() {
            @Override
            protected void updateItem(Cliente item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getNome() + " - CPF: " + item.getCpf());
                }
            }
        });

        comboClientes.setCellFactory(listView -> new javafx.scene.control.ListCell<Cliente>() {
            @Override
            protected void updateItem(Cliente item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getNome() + " - CPF: " + item.getCpf());
                }
            }
        });
    }

    @FXML
    void salvarVeiculo(ActionEvent event) throws IOException {
        String placa = txtPlaca.getText().trim().toUpperCase();
        String modelo = txtModelo.getText().trim();
        String ano = txtAno.getText().trim();
        Cliente clienteSelecionado = comboClientes.getValue();


        if (placa.isEmpty() || modelo.isEmpty() || ano.isEmpty()) {
            lblMensagem.setText("Preencha todos os campos!");
            return;
        }

        if (clienteSelecionado == null) {
            lblMensagem.setText("Selecione um cliente!");
            return;
        }

        if (ano.length() != 4 || !ano.matches("\\d{4}")) {
            lblMensagem.setText("Ano inválido! Digite 4 dígitos.");
            return;
        }



        boolean sucesso = VeiculoDAO.adicionarVeiculo(placa, modelo, ano, clienteSelecionado.getId());

        if (sucesso) {
            alertas.mostrarConfirmacao("Veículo cadastrado com sucesso!");
            MudarTela.trocarJanela(event, "/View/Veiculos.fxml");
        } else {
            alertas.mostrarErro("Erro ao cadastrar veículo, tente novamente");
        }
    }

    @FXML
    void voltarParaPainel(ActionEvent event) throws IOException {
        MudarTela.trocarJanela(event, "/View/PainelVeiculos.fxml");
    }
}