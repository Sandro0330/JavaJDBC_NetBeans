package br.com.jdbc.model.dao;

import br.com.jdbc.model.bean.Categoria;
import br.com.jdbc.model.bean.Produto;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProdutoDAOTest {
    
    public ProdutoDAOTest() {
    }

    @Test
    public void inserir() {
        
       Categoria categoria = new Categoria();
       categoria.setId(1);
        
       Produto produto = new Produto();
       produto.setDescricao("Feijão");
       produto.setQtd(20);
       produto.setValor(9.90);
       produto.setCategoria(categoria);
       
       ProdutoDAO dao = new ProdutoDAO();
       
       if(dao.save(produto)) {
           System.out.println("Salvo com sucesso!!");
       } else {
           fail("Erro ao salvar");
       }     
    }
}
