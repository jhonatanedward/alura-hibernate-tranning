package br.com.alura.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.model.Pedido;
import br.com.alura.loja.vo.RelatorioDeVendasVo;

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
	
	public List<RelatorioDeVendasVo> relatorioDeVendas(){
		String jpql = "SELECT new br.com.alura.loja.vo.RelatorioDeVendasVo(produto.nome, SUM(item.quantidade), MAX(pedido.data)) "
				+ "FROM Pedido pedido "
				+ "JOIN pedido.itens item "
				+ "JOIN item.produto produto "
				+ "GROUP BY produto.nome "
				+ "ORDER BY item.quantidade DESC";
		return entityManager.createQuery(jpql, RelatorioDeVendasVo.class).getResultList();
	}
}
