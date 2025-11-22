package Model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Cliente {
    private SimpleStringProperty id;
    private SimpleStringProperty nome;
    private SimpleStringProperty cpf;
    private SimpleStringProperty telefone;
    private SimpleBooleanProperty isVip;


    public Cliente(String id, String nome, String cpf, String telefone, boolean isVip){
        this.id = new SimpleStringProperty(id);
        this.nome = new SimpleStringProperty(nome);
        this.cpf = new SimpleStringProperty(cpf);
        this.telefone = new SimpleStringProperty(telefone);
        this.isVip = new SimpleBooleanProperty(isVip);
    }

    // Construtor sem ID (para novos clientes)
    public Cliente(String nome, String cpf, String telefone, boolean isVip) {
        this.id = new SimpleStringProperty("");
        this.nome = new SimpleStringProperty(nome);
        this.cpf = new SimpleStringProperty(cpf);
        this.telefone = new SimpleStringProperty(telefone);
        this.isVip = new SimpleBooleanProperty(isVip);
    }

    public SimpleStringProperty getId() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public SimpleStringProperty getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public SimpleStringProperty getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf.set(cpf);
    }

    public SimpleStringProperty getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone.set(telefone);
    }
    public SimpleBooleanProperty isVipProperty() {
        return isVip;
    }

}