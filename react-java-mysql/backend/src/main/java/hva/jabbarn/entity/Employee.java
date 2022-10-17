package hva.jabbarn.entity;

import hva.jabbarn.util.Identifiable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee implements Identifiable {

    @Id
    @GeneratedValue
    private long emp_no;

    @Column(nullable = false)
    private Date birth_date;
    @Column(nullable = false)
    private String first_name;
    @Column(nullable = false)
    private String last_name;
    @Column(nullable = false)
    private Date hire_date;

    public Employee() {
    }

    public Employee(int id) {
        this.emp_no = id;
    }

    @Override
    public long getId() {
        return emp_no;
    }

    @Override
    public void setId(long id) {
        this.emp_no = id;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }
}
