package br.com.alura.loja.dao;

import javax.persistence.EntityManager;

import br.com.alura.loja.model.Categoria;

public class CategoriaDAO {
	private EntityManager entityManager;

	public CategoriaDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	public void cadastrar(Categoria categoria) {
		this.entityManager.persist(categoria);
	}
}
