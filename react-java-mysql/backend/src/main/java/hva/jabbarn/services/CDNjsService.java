package hva.jabbarn.services;

import hva.jabbarn.entity.Employee;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CDNjsService {
    private static final String URL = "https://api.cdnjs.com/libraries/";
    private final RestTemplate restTemplate = new RestTemplate();

    public List<Object> getLibraries() {

        return Collections.singletonList(restTemplate.getForObject(URL, Object.class));
    }
    @Cacheable("libraries")
    public List<Object> getCachedLibraries() {
        return Collections.singletonList(restTemplate.getForObject(URL, Object.class));
    }

    @Async
    public CompletableFuture<List<Object>> getAsyncLibraries() {
        List<Object> libraries = Collections.singletonList(restTemplate.getForObject(URL, Object.class));
        return CompletableFuture.completedFuture(libraries);
    }
}
