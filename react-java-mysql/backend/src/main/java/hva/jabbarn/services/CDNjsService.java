package hva.jabbarn.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class CDNjsService {

    public List<Object> getAll() {
        String url = "https://api.cdnjs.com/libraries/";
        RestTemplate restTemplate = new RestTemplate();

        return Collections.singletonList(restTemplate.getForObject(url, Object.class));
    }
}
