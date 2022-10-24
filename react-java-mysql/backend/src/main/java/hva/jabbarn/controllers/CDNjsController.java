package hva.jabbarn.controllers;

import hva.jabbarn.services.CDNjsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/libraries")
public class CDNjsController {

    private final CDNjsService service;

    public CDNjsController(CDNjsService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<Object> getAllLibraries() {
        return service.getAll();
    }
}

