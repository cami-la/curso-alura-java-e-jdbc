package br.com.alura.jpa.modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.MediaComData;

public class MovimentacaoDao {
	
	private EntityManager em;
	

	public MovimentacaoDao(EntityManager em) {
		this.em = em;
	}

	public List<MediaComData> getMediaDiariaDasMovimentacoes() {
		
		String jpql = "SELECT NEW br.com.alura.jpa.modelo.MediaComData(AVG(m.valor), DAY(m.data), MONTH(m.data)) FROM Movimentacao m group by DAY(m.data), MONTH(m.data), YEAR(m.data)";
		
		TypedQuery<MediaComData> query = em.createQuery(jpql, MediaComData.class);
		
		return query.getResultList();
	}
	
	public BigDecimal getSomaDasMovimentacoes() {
		
		
		String jpql = "SELECT SUM(m.valor) FROM Movimentacao m";
		TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
		
		BigDecimal somaDasMovimentacoes = query.getSingleResult();
		
		return somaDasMovimentacoes;
	}
}
