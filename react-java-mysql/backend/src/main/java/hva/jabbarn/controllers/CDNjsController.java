package hva.jabbarn.controllers;

import hva.jabbarn.services.CDNjsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@CrossOrigin
@RequestMapping("/libraries")
public class CDNjsController {

    private final CDNjsService service;

    public CDNjsController(CDNjsService service) {
        this.service = service;
    }
    @GetMapping("/normal")
    public List<Object> getLibraries() {
        return service.getLibraries();
    }
    @GetMapping("/async")
    public CompletableFuture<List<Object>> getAsyncLibraries() {
        return service.getAsyncLibraries();
    }

    @GetMapping("/cached")
    public List<Object> getCachedLibraries() {
        return service.getCachedLibraries();
    }
}

