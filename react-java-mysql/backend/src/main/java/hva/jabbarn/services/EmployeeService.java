package hva.jabbarn.services;

import hva.jabbarn.entity.Employee;
import hva.jabbarn.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    @Cacheable("employee")
    public List<Employee> getCachedEmployees() {
        return repository.findAll();
    }

    @Async
    public CompletableFuture<List<Employee>> getAsyncEmployees() {
        return CompletableFuture.completedFuture(repository.findAll());
    }
    public List<Employee> getEmployees() {
        return repository.findAll();
    }
}
