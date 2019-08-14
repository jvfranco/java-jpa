package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
	EntityManager em = new JPAUtil().getEntityManager();
	em.getTransaction().begin();
	
	Movimentacao movimentacao = em.find(Movimentacao.class, 3);
	Conta conta = movimentacao.getConta();
	
	System.out.println("Titular: " + conta.getTitular());
	System.out.println("Total de Movimenta��es: " + conta.getMovimentacoes().size());
	
	em.getTransaction().commit();
	em.close();

	}

}
