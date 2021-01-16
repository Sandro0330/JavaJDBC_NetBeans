package br.com.jdbc.model.dao;

import br.com.jdbc.connection.ConnectionFactory;
import br.com.jdbc.model.bean.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriaDAO {
    
    private Connection con = null;

    public CategoriaDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public boolean save(Categoria categoria) {
        String sql = "INSERT INTO categoria (descricao) VALUES (?)";
        
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, categoria.getDescricao());
            pstm.executeLargeUpdate();
            return true;
        } catch (SQLException ex) {
           System.err.println("Erro: " + ex);
           return false;
        } finally {
            ConnectionFactory.closeConnection(con, pstm );
        }
    }
    
    public List<Categoria> findAll() {
        String sql = "SELECT * FROM categoria";
        
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        List<Categoria> categorias = new ArrayList<>();
      
        try {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                Categoria categoria = new Categoria();           
                categoria.setDescricao(rs.getString("descricao"));
                categorias.add(categoria);
            }
            
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, pstm, rs);
        }  
        return categorias;
    } 
    
    public boolean update(Categoria categoria) {
        String sql = "UPDATE categoria SET descricao = ? WHERE id = ?";
        
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, categoria.getDescricao());
            pstm.setInt(2, categoria.getId());
            pstm.executeLargeUpdate();
            return true;
        } catch (SQLException ex) {
           System.err.println("Erro: " + ex);
           return false;
        } finally {
            ConnectionFactory.closeConnection(con, pstm );
        }
    }
}
