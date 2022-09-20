package ru.mukhametdinov.testrestlab.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.mukhametdinov.testrestlab.model.Response;
@Service
public class SenderMessage implements MessageSender{
    @Override
    public Response send(Response response) {
        RestTemplate restTemplate = new RestTemplate();
        String web = "http://localhost:8080/feed";
        restTemplate.postForLocation(web,response);
        return response;
    }
}
