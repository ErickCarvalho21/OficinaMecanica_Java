package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VeiculoDAO {

    public static boolean adicionarVeiculo(String placa, String modelo, String ano, String idCliente) {
        Connection conexao = ConexaoComBanco.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(
                    "INSERT INTO veiculo (placa, modelo, ano, id_cliente) VALUES (?,?,?,?)"
            );
            stmt.setString(1, placa);
            stmt.setString(2, modelo);
            stmt.setString(3, ano);
            stmt.setInt(4, Integer.parseInt(idCliente));

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao adicionar veículo: " + e.getMessage());
            return false;
        } finally {
            ConexaoComBanco.fechaConexao(conexao, stmt);
        }
    }
}
