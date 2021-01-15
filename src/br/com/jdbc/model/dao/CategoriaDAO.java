package br.com.jdbc.model.dao;

import br.com.jdbc.connection.ConnectionFactory;
import br.com.jdbc.model.bean.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    
    
    
    
}
