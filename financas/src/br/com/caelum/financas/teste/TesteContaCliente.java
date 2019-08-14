package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Cliente;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteContaCliente {

	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente();
		cliente1.setNome("Leonardo");
		cliente1.setEndereco("Rua Fulano, 123");
		cliente1.setProfissao("Professor");
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Rodrigo");
		cliente2.setEndereco("Rua Fulano, 568");
		cliente2.setProfissao("Professor");
		
		Conta conta = new Conta();
		conta.setId(2);
		
		cliente2.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		//em.persist(cliente1);
		em.persist(cliente2);
		
		em.getTransaction().commit();
		em.close();
	}

}
