package entities;

import embeddables.Address;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int budget;

    @ElementCollection
    @CollectionTable(name = "tableWithAddresses", joinColumns = @JoinColumn(name = "CompanyID"))
    @AttributeOverride(name = "number", column = @Column(name = "no"))
    @AttributeOverride(name = "street", column = @Column(name = "CompanyStreet"))
    @Column(name = "CompanyAddress")
    private Collection<Address> addresses;

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Collection<Address> addresses) {
        this.addresses = addresses;
    }
}
