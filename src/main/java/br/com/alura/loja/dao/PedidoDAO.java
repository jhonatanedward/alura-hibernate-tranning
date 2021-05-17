package br.com.alura.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.model.Pedido;

public class PedidoDAO {
	
	private EntityManager entityManager;

	public PedidoDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	public void cadastrar(Pedido pedido) {
		this.entityManager.persist(pedido);
	}
	
	public BigDecimal valorTotalVendido() {
		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
		return entityManager.createQuery(jpql, BigDecimal.class).getSingleResult();
	}
}
