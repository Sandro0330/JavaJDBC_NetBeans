package br.com.jdbc.model.dao;

import br.com.jdbc.model.bean.Categoria;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;


public class CategoriaDAOTest {
    
    public CategoriaDAOTest() {
    }

    @Test
    @Ignore
    public void inserir() {
        Categoria cat = new Categoria("Roupas");
        CategoriaDAO dao = new CategoriaDAO();
        
        if (dao.save(cat)) {
            System.out.println("Salvo com sucesso!");
        } else {
            fail("Erro ao salvar");
        }
    }
    
    @Test
    public void listar() {
        CategoriaDAO dao = new CategoriaDAO();
        
        for(Categoria c: dao.findAll()) {
            System.out.println("Descrição " + c.getDescricao());
        }
    }
}
