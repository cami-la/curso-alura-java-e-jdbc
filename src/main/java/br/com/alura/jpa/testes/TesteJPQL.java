package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQL {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();
		conta.setId(1L);
		String jpql = "SELECT m FROM Movimentacao m WHERE m.conta = :pConta ORDER BY m.valor DESC ";

		TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
		query.setParameter("pConta", conta);

		List<Movimentacao> resultList = query.getResultList();

//		for (Movimentacao m : resultList) {
//			System.out.println("Descrição: " + m.getDescricao());
//			System.out.println("Tipo: " + m.getTipoMovimentacao());
//		}

		resultList.stream().forEach(m -> {
			System.out.println("Descrição" + m.getDescricao());
			System.out.println("Tipo: " + m.getTipoMovimentacao());
		});
	}

}
