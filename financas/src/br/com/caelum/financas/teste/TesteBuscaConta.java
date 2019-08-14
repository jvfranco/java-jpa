package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteBuscaConta {
	
	public static void main(String[] args) {
		
		//Quando o objeto ainda n�o foi persistido ele se encontra em estado transient
		//significa que qndo o sistema for encerrado o objeto n�o ser� salvo no bd
		//e encerrar� com o sistema
		
		//Quando o objeto foi persistido(salvo), no banco, e foi selecionado
		//se encontra em estado managed, significa que est� em modo de manipula��o
		//pode receber atualiza��es em qualquer momento
		
		//Quando a transa��o de busca j� foi encerrado e reabrimos o objeto ele est�
		//em modo detached, para que as atualiza��es sejam realizadas, � preciso que o
		//objeto sej� alvo do metodo merge(), para que possa ser atualizado e salvo no
		//banco de dados
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 1);
		
		System.out.println(conta);
		
		conta.setTitular("Jo�o");
		
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
