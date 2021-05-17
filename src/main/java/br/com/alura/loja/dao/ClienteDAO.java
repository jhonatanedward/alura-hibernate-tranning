package br.com.alura.loja.dao;

import javax.persistence.EntityManager;

import br.com.alura.loja.model.Cliente;
import br.com.alura.loja.model.Produto;

public class ClienteDAO {
	
	private EntityManager entityManager;

	public ClienteDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	public void cadastrar(Cliente cliente) {
		this.entityManager.persist(cliente);
	}
	
	public Cliente buscarPorId(Long id) {
		return entityManager.find(Cliente.class, id);
	}
	
}
