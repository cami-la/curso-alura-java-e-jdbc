package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TesteMediaDiariaDasMovimentacoes {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "SELECT AVG(m.valor) FROM Movimentacao m group by DAY(m.data), MONTH(m.data), YEAR(m.data)";
		
		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		
		List<Double> mediaDasMovimentacoes = query.getResultList();
		
		mediaDasMovimentacoes.stream().forEach(mm -> System.out.println(mm));
	}

}
