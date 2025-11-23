package DB;

import Model.Peca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class PecaDAO {



    public static Peca buscarPorId(String idPeca) {
        Connection conexao = ConexaoComBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conexao.prepareStatement("SELECT * FROM peca WHERE id_peca = ?");
            stmt.setInt(1, Integer.parseInt(idPeca));
            rs = stmt.executeQuery();

            DecimalFormat df = new DecimalFormat("#,##0.00");

            if (rs.next()) {
                return new Peca(
                        rs.getString("id_peca"),
                        rs.getString("nome_peca"),
                        df.format(rs.getDouble("preco_unitario")),
                        rs.getString("quantidade_estoque")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar peça: " + e.getMessage());
        } finally {
            ConexaoComBanco.fechaConexao(conexao, stmt, rs);
        }

        return null;
    }
}
