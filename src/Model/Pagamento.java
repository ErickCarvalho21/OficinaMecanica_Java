package Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Pagamento {
    private SimpleStringProperty idPagamento;
    private SimpleStringProperty idOrdem;
    private SimpleDoubleProperty valor;
    private SimpleStringProperty formaPagamento;
    private SimpleStringProperty status;
    private SimpleStringProperty dataPagamento;

    public Pagamento(String idPagamento, String idOrdem, double valor, String formaPagamento, String status, String dataPagamento) {
        this.idPagamento = new SimpleStringProperty(idPagamento);
        this.idOrdem = new SimpleStringProperty(idOrdem);
        this.valor = new SimpleDoubleProperty(valor);
        this.formaPagamento = new SimpleStringProperty(formaPagamento);
        this.status = new SimpleStringProperty(status);
        this.dataPagamento = new SimpleStringProperty(dataPagamento);
    }


    public String getIdPagamento() { return idPagamento.get(); }
    public String getIdOrdem() { return idOrdem.get(); }
    public double getValor() { return valor.get(); }
    public String getFormaPagamento() { return formaPagamento.get(); }
    public String getStatus() { return status.get(); }
    public String getDataPagamento() { return dataPagamento.get(); }

    public SimpleStringProperty formaPagamentoProperty() { return formaPagamento; }
    public SimpleDoubleProperty valorProperty() { return valor; }
    public SimpleStringProperty statusProperty() { return status; }
}