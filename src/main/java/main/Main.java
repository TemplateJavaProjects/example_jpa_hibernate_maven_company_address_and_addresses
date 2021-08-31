package main;

import entities.Company;

import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        // EntityManagerFactory
        // EntityManager
        var emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        var em1 = emf.createEntityManager();

        Company company = new Company();
        company.setStreet("Katowicka");
        company.setNumber("123a");
        company.setBudget(100_000);

        em1.getTransaction().begin();

        em1.persist(company); // adding the instance in the context

        em1.getTransaction().commit();
        em1.close();

    }
}