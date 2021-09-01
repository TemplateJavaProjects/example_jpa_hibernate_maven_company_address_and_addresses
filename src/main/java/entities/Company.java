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
    @AttributeOverride(name = "number", column = @Column(name = "no1"))
    @AttributeOverride(name = "street", column = @Column(name = "CompanyStreet1"))
    private Address address1;

    @Embedded
    @AttributeOverride(name = "number", column = @Column(name = "no2"))
    @AttributeOverride(name = "street", column = @Column(name = "CompanyStreet2"))
    private Address address2;

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public Address getAddress1() {
        return address1;
    }

    public void setAddress1(Address address1) {
        this.address1 = address1;
    }

    public Address getAddress2() {
        return address2;
    }

    public void setAddress2(Address address2) {
        this.address2 = address2;
    }
}
