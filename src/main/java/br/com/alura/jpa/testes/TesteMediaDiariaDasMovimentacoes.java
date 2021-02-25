package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.MediaComData;

public class TesteMediaDiariaDasMovimentacoes {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "SELECT NEW br.com.alura.jpa.modelo.MediaComData(AVG(m.valor), DAY(m.data), MONTH(m.data)) FROM Movimentacao m group by DAY(m.data), MONTH(m.data), YEAR(m.data)";
		
		TypedQuery<MediaComData> query = em.createQuery(jpql, MediaComData.class);
		
		List<MediaComData> mediaDasMovimentacoes = query.getResultList();
		
		for (MediaComData resultado : mediaDasMovimentacoes) {
			System.out.println("A média das movimentações do dia " + resultado.getDia() + "/" + resultado.getMes() + " é: R$" + resultado.getValor());
		}
	}

}
