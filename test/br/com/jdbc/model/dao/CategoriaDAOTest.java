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
    @Ignore
    public void atualizar() {
        Categoria cat = new Categoria("Roupa");
        cat.setId(1);
        
        CategoriaDAO dao = new CategoriaDAO();
        
        if (dao.update(cat)) {
            System.out.println("Atualização realizada com sucesso!");
        } else {
            fail("Erro ao salvar");
        }
    }
    
    @Test
    public void deletar() {
        Categoria cat = new Categoria();
        cat.setId(3);
        
        CategoriaDAO dao = new CategoriaDAO();
        if(dao.delete(cat)) {
            System.err.println("Removido com sucesso!");
        } else {
            fail("Erro ao deletar");
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
