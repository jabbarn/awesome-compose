package hva.jabbarn.controllers;

import hva.jabbarn.entity.Employee;
import hva.jabbarn.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

//    @GetMapping("/")
//    public Greeting showHome(String name, Model model) {
//        return repository.findById(1).orElse(new Greeting("Not Found 😕"));
//    }

    @GetMapping("")
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }
}
