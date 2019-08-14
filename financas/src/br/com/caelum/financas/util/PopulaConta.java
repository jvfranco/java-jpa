package br.com.caelum.financas.util;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;

public class PopulaConta {
	
	public static void main(String[] args) {
	
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();		
		
		Conta conta1 = new Conta();
		Conta conta2 = new Conta();
		Conta conta3 = new Conta();
		Conta conta4 = new Conta();
		Conta conta5 = new Conta();
		
		conta1.setBanco("130 - Banco do Brasil");
		conta1.setNumero("58964-5");
		conta1.setAgencia("5968");
		conta1.setTitular("Rodrigo Esteves");
		
		conta2.setBanco("237 - Banco Bradesco");
		conta2.setNumero("86759-1");
		conta2.setAgencia("1745");
		conta2.setTitular("Paulo Roberto Souza");
		
		conta3.setBanco("341 - Banco Itau Unibanco");
		conta3.setNumero("46346-3");
		conta3.setAgencia("4606");
		conta3.setTitular("Antonio Duraes");
		
		conta4.setBanco("033 - Banco Santander");
		conta4.setNumero("12345-6");
		conta4.setAgencia("9876");
		conta4.setTitular("Leandra Marques");
		
		conta5.setBanco("104 - Caixa Economica Federal");
		conta5.setNumero("98654-3");
		conta5.setAgencia("1234");
		conta5.setTitular("Alexandre Duarte");
		
		manager.persist(conta1);
		manager.persist(conta2);
		manager.persist(conta3);
		manager.persist(conta4);
		manager.persist(conta5);
		
		manager.getTransaction().commit();
		
		manager.close();
		
		
	}
	}
	
