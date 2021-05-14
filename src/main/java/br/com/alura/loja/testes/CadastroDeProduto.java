package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.model.Categoria;
import br.com.alura.loja.model.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Categoria categoria = new Categoria("Celulares");
		
		Produto celular = new Produto(
				"Samsung Galaxy",
				"Android 10, Camera de 20MP", 
				new BigDecimal("7000.00"), 
				categoria);

		EntityManager entityManager = JPAUtil.getEntityManager();
		
		ProdutoDAO produtoDao = new ProdutoDAO(entityManager);
		CategoriaDAO categoriaDao = new CategoriaDAO(entityManager);
		
		entityManager.getTransaction().begin();
		
		categoriaDao.cadastrar(categoria);
		produtoDao.cadastrar(celular);
		entityManager.getTransaction().commit();
		
		entityManager.close();

	}
}
