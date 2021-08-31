package entities;


import javax.persistence.*;

@Entity
@SecondaryTable(name = "address",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "company"))
//company column in 'address' table in DB will be used now as foreign key of Company entity
//if u didnt specify that then 'company' column would be not used and JPA would use
//same id for company and address. Leaving empty column is not desirable.
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int budget;

    @Column(table = "address", name = "CompanyStreet")
    private String street;

    @Column(table = "address", name = "no")
    private String number;

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
