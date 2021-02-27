package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.dao.MovimentacaoDao;

public class TestaMovimentacoesFiltradasPorDataCriteria {

	public static void main(String[] args) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
//		EntityManager em = emf.createEntityManager();
		
		MovimentacaoDao movimentacaoDao = new MovimentacaoDao(Persistence.createEntityManagerFactory("contas").createEntityManager());
		List<Movimentacao> movimentacoesFiltradasPorData = movimentacaoDao.getMovimentacoesFiltradasPorData(21, null, null);
		movimentacoesFiltradasPorData.stream().forEach(mfd -> {
			System.out.println("Descrição -> " + mfd.getDescricao());
			System.out.println("Valor -> " + mfd.getValor());
			System.out.println("-----------------------------------");
		});
	}

}
