package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TesteMediaDiariaDasMovimentacoes {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "SELECT AVG(m.valor), DAY(m.data), MONTH(m.data) FROM Movimentacao m group by DAY(m.data), MONTH(m.data), YEAR(m.data)";
		
		Query query = em.createQuery(jpql);
		
		List<Object[]> mediaDasMovimentacoes = query.getResultList();
		
		for (Object[] resultado : mediaDasMovimentacoes) {
			System.out.println("A média das movimentações do dia " + resultado[1] + "/" + resultado[2] + " é: R$" + resultado[0]);
		}
	}

}
