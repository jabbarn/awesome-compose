package hva.jabbarn.repository;

import hva.jabbarn.entity.Employee;
import hva.jabbarn.entity.Greeting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public class EmployeeRepository extends AbstractEntityRepositoryJPA<Employee> {
    public EmployeeRepository() {
        super(Employee.class);
    }

    public List<Employee> findByDistributorId(int id) {
        return entityManager.createQuery("SELECT employee FROM Employee employee WHERE employee.emp_no = '" + id + "'", Employee.class).getResultList();
    }
}

