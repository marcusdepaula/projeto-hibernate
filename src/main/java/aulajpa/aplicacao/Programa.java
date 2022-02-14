package aulajpa.aplicacao;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import aulajpa.dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {

		Pessoa p1 = new Pessoa(null,"Fernando","Fernando@gmail.com" );
		Pessoa p2 = new Pessoa(null,"Maria Silva","maria@gmail.com" );
		Pessoa p3 = new Pessoa(null,"Pedro Silva","pedro@gmail.com" );
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em= emf.createEntityManager();
		
/*		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit(); */
		
		Pessoa p=em.find(Pessoa.class, 5);
		
		Pessoa pRemover = em.find(Pessoa.class, 3);
		em.getTransaction().begin();
		em.remove(pRemover);
		em.getTransaction().commit();
		
		
		System.out.println("pronto!");
		System.out.println(p);
		emf.close();
		em.close();
		

	}

}
