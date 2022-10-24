package hva.jabbarn.repository;

import hva.jabbarn.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository extends AbstractEntityRepositoryJPA<Employee> {
    public EmployeeRepository() {
        super(Employee.class);
    }
}

