package hva.jabbarn.repository;

import hva.jabbarn.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class EmployeeRepository extends AbstractEntityRepositoryJPA<Employee> {

    public EmployeeRepository() {
        super(Employee.class);
    }
}

