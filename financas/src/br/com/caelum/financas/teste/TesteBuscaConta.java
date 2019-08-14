package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteBuscaConta {
	
	public static void main(String[] args) {
		
		//Quando o objeto ainda não foi persistido ele se encontra em estado transient
		//significa que qndo o sistema for encerrado o objeto não será salvo no bd
		//e encerrará com o sistema
		
		//Quando o objeto foi persistido(salvo), no banco, e foi selecionado
		//se encontra em estado managed, significa que está em modo de manipulação
		//pode receber atualizações em qualquer momento
		
		//Quando a transação de busca já foi encerrado e reabrimos o objeto ele está
		//em modo detached, para que as atualizações sejam realizadas, é preciso que o
		//objeto sejá alvo do metodo merge(), para que possa ser atualizado e salvo no
		//banco de dados
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 1);
		
		System.out.println(conta);
		
		conta.setTitular("João");
		
		System.out.println(conta);
				
		em.getTransaction().commit();
		
		EntityManager em2 = new JPAUtil().getEntityManager();
		em2.getTransaction().begin();
		
		conta.setTitular("Leonardo");
		em2.merge(conta);
		
		em2.getTransaction().commit();
		
		System.out.println(conta);
	}
	
}
