package br.com.jdbc.model.dao;

import br.com.jdbc.connection.ConnectionFactory;
import br.com.jdbc.model.bean.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {

    private Connection con = null;

    public ProdutoDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean save(Produto produto) {
        String sql = "INSERT INTO produto (descricao, qtd, valor, categoria_id) VALUES (?,?,?,?)";

        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, produto.getDescricao());
            pstm.setInt(2, produto.getQtd());
            pstm.setDouble(3, produto.getValor());
            pstm.setInt(4, produto.getCategoria().getId());//Composição com objeto categoría
            pstm.executeLargeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, pstm);
        }
    }
}
