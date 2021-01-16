package br.com.jdbc.model.dao;

import br.com.jdbc.connection.ConnectionFactory;
import br.com.jdbc.model.bean.Categoria;
import br.com.jdbc.model.bean.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    public List<Produto> findAll() {
        String sql = "select * from view_produtocategoria";
        
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
      
        try {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                Produto produto = new Produto();           
                produto.setDescricao(rs.getString("p_id"));
                produto.setQtd(rs.getInt("qtd")); 
                produto.setValor(rs.getDouble("valor"));
                
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("c_id"));
                categoria.setDescricao(rs.getString("c_desc"));
                produto.setCategoria(categoria);
                
                
                produtos.add(produto);
            }
            
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, pstm, rs);
        }  
        return produtos;
    } 
}
