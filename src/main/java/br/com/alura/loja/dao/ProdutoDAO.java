package br.com.alura.loja.dao;

import javax.persistence.EntityManager;

import br.com.alura.loja.model.Produto;

public class ProdutoDAO {
	
	
	private EntityManager entityManager;

	public ProdutoDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	public void cadastrar(Produto produto) {
		this.entityManager.persist(produto);
	}
	
}
