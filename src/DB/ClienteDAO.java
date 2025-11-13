package DB;

import Model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {

    // função testada funcionando normalmente
    public static void adicionarCliente (){

        Connection conexao = ConexaoComBanco.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("INSERT INTO cliente (nome_cliente, cpf_cliente, telefone) VALUES (?,?,?)");
            stmt.setString(1, "lucas");
            stmt.setString(2, "111.234.343-54");
            stmt.setString(3, "(89) 90434-2311");

            stmt.executeUpdate();
        } catch (SQLException e) {
        System.out.println("Erro no banco de dados" + e);
        }

    }

    public static void main(String[] args) {
        adicionarCliente();
    }
}
