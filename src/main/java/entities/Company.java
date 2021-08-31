package entities;

import embeddables.Address;

import javax.persistence.*;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int budget;

    @Embedded
    @AttributeOverride(name = "number", column = @Column(name = "no"))
    @AttributeOverride(name = "street", column = @Column(name = "CompanyStreet"))
    private Address addressOfThisCompany;

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public Address getAddress() {
        return addressOfThisCompany;
    }

    public void setAddress(Address addressOfThisCompany) {
        this.addressOfThisCompany = addressOfThisCompany;
    }
}
