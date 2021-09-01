package entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int budget;

    @OneToMany(mappedBy = "company", cascade = CascadeType.PERSIST)
    private List<Address> addressOfThisCompany;

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public List<Address> getAddressOfThisCompany() {
        return addressOfThisCompany;
    }

    public void setAddressOfThisCompany(List<Address> addressOfThisCompany) {
        this.addressOfThisCompany = addressOfThisCompany;
    }
}
