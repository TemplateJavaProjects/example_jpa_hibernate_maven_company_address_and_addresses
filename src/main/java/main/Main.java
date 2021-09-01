package main;

import embeddables.Address;
import entities.Company;

import javax.persistence.Persistence;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // EntityManagerFactory
        // EntityManager
        var emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        var em1 = emf.createEntityManager();

        Address address1 = new Address();
        address1.setStreet("Katowicka");
        address1.setNumber("123a");

        Address address2 = new Address();
        address2.setStreet("Batorego");
        address2.setNumber("3B");

        Company company = new Company();
        company.setAddresses(new ArrayList<>());
        company.getAddresses().add(address1);
        company.getAddresses().add(address2);
        company.setBudget(100_000);

        em1.getTransaction().begin();

        em1.persist(company); // adding the instance in the context

        em1.getTransaction().commit();
        em1.close();

    }
}