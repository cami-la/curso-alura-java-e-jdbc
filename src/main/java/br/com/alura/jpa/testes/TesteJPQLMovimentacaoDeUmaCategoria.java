package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQLMovimentacaoDeUmaCategoria {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "SELECT m FROM Movimentacao m JOIN m.categorias c WHERE c = :pCategoria";
		
		Categoria categoria = new Categoria();
		categoria.setId(3L);
		
		TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
		query.setParameter("pCategoria", categoria);
		
		List<Movimentacao> movimentacoes = query.getResultList();
		
		movimentacoes.stream().forEach(m -> {
			System.out.println("Categorias: " + m.getCategorias());
			System.out.println("Descrição" + m.getDescricao());
			System.out.println("Tipo: " + m.getTipoMovimentacao());
			
		});
		
//		movimentacoes.stream().forEach(System.out::println);
		
	}

}
