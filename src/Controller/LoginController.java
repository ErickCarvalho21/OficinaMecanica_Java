package Controller;

import DB.ConexaoComBanco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class LoginController {

        @FXML
        private Button botaoLogin;

        @FXML
        private TextField emailDoLogin;

        @FXML
        private PasswordField senhaDoLogin;

    @FXML
    void fazerLogin(ActionEvent event) {
        Validacoes email = new Validacoes();
        String email_valido = emailDoLogin.getText();
        String senha = senhaDoLogin.getText();
        boolean isValidEmail = email.validarEmail(email_valido);

        Connection conexao = ConexaoComBanco.getConnection();
        PreparedStatement stmt = null;
        if (isValidEmail) {
            try {
                stmt = conexao.prepareStatement("INSERT INTO administrador (email, senha) VALUES (?, ?)"); // previne de SQL injection
                stmt.setString(1, email_valido);
                stmt.setString(2, senha);

                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null,"Sucesso ao salvar no banco");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar" + e);
            }finally {
                ConexaoComBanco.fechaConexao(conexao, stmt);
            }
        }else{
            JOptionPane.showMessageDialog(null, "email, não é válido! tente novamente!");

        }


    }

}
