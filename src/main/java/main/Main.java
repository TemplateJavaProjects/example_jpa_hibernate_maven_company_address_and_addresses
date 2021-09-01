package main;

import entities.Address;
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
        company.setAddressOfThisCompany(new ArrayList<>());
        company.getAddressOfThisCompany().add(address1);
        company.getAddressOfThisCompany().add(address2);
        company.setBudget(100_000);
        //in bi-directional I set also info about company to address for JPA
        address1.setCompany(company);
        address2.setCompany(company);

        em1.getTransaction().begin();

        /*
        em1.persist(address1); // adding the instance in the context
        em1.persist(address2);
        */
        //OR
        em1.persist(company);

        em1.getTransaction().commit();
        em1.close();

    }
}