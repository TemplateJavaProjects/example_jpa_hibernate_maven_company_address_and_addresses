package main;

import entities.Address;
import entities.Company;

import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        // EntityManagerFactory
        // EntityManager
        var emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        var em1 = emf.createEntityManager();

        Address address = new Address();
        address.setStreet("Katowicka");
        address.setNumber("123a");

        Company company = new Company();
        company.setAddress(address);
        company.setBudget(100_000);
        //in bi-directional I set also info about company to address for JPA
        address.setCompany(company);

        em1.getTransaction().begin();

        em1.persist(company); // adding the instance in the context

        em1.getTransaction().commit();
        em1.close();

    }
}