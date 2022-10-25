package hva.jabbarn.controllers;

import hva.jabbarn.entity.Employee;
import hva.jabbarn.services.EmployeeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
    @GetMapping("/normal")
    public List<Employee> getEmployees() {
        return service.getEmployees();
    }
    @GetMapping("/async")
    public CompletableFuture<List<Employee>> getAsyncEmployees() {
        return service.getAsyncEmployees();
    }

    @GetMapping("/cached")
    public List<Employee> getCachedEmployees() {
        return service.getCachedEmployees();
    }
}
