package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;

public class TestaRelatorioDasMovimentacoes {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager(); 
		
		String jpql = "SELECT c FROM Conta c LEFT JOIN FETCH c.movimentacoes";
		TypedQuery<Conta> query = em.createQuery(jpql, Conta.class);
		
		List<Conta> contas = query.getResultList();
		
		contas.stream().forEach(c ->{
			System.out.println("Titular: " + c.getTitular());
			System.out.println("Número: " + c.getAgencia());
			System.out.println("Agência: " + c.getNumero());
				System.out.println("Movimentações: " + c.getMovimentacoes());
		});
		
	}

}
