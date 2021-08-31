package entities;

import javax.persistence.*;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int budget;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_fk")
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
