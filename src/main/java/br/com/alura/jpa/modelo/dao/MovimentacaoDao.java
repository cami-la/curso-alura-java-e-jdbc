package br.com.alura.jpa.modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.MediaComData;
import br.com.alura.jpa.modelo.Movimentacao;

public class MovimentacaoDao {
	
	private EntityManager em;
	

	public MovimentacaoDao(EntityManager em) {
		this.em = em;
	}
	
	public List<Movimentacao> getMovimentacoesFiltradasPorData(Integer dia, Integer mes, Integer ano) {
		
		
		return null;
	}

	public List<MediaComData> getMediaDiariaDasMovimentacoes() {
		
		TypedQuery<MediaComData> query = em.createNamedQuery("mediaDiariaMovimentacoes", MediaComData.class);
		
		return query.getResultList();
	}
	
	public BigDecimal getSomaDasMovimentacoes() {
		
		
		String jpql = "SELECT SUM(m.valor) FROM Movimentacao m";
		TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
		
		BigDecimal somaDasMovimentacoes = query.getSingleResult();
		
		return somaDasMovimentacoes;
	}
}
