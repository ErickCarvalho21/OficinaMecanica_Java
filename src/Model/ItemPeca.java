package Model;

import javafx.beans.property.SimpleStringProperty;

public class ItemPeca {
    private SimpleStringProperty idPeca;
    private SimpleStringProperty nomePeca;
    private SimpleStringProperty quantidade;
    private SimpleStringProperty precoUnitario;
    private SimpleStringProperty total;

    public ItemPeca(String idPeca, String nomePeca, String quantidade, String precoUnitario, String total) {
        this.idPeca = new SimpleStringProperty(idPeca);
        this.nomePeca = new SimpleStringProperty(nomePeca);
        this.quantidade = new SimpleStringProperty(quantidade);
        this.precoUnitario = new SimpleStringProperty(precoUnitario);
        this.total = new SimpleStringProperty(total);
    }

    public SimpleStringProperty idPecaProperty() {
        return idPeca;
    }

    public SimpleStringProperty nomePecaProperty() {
        return nomePeca;
    }

    public SimpleStringProperty quantidadeProperty() {
        return quantidade;
    }

    public SimpleStringProperty precoUnitarioProperty() {
        return precoUnitario;
    }

    public SimpleStringProperty totalProperty() {
        return total;
    }

    public String getIdPeca() {
        return idPeca.get();
    }

    public String getNomePeca() {
        return nomePeca.get();
    }

    public String getQuantidade() {
        return quantidade.get();
    }

    public String getPrecoUnitario() {
        return precoUnitario.get();
    }

    public String getTotal() {
        return total.get();
    }
}