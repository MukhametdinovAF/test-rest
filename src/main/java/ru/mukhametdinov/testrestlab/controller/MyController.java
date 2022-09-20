package ru.mukhametdinov.testrestlab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.mukhametdinov.testrestlab.model.Request;
import ru.mukhametdinov.testrestlab.model.Response;
import ru.mukhametdinov.testrestlab.service.MessageSender;
import ru.mukhametdinov.testrestlab.service.MyService;

@RestController
public class MyController {
    private final MyService myService;
    private final MessageSender messageSender;

    @Autowired
    public MyController (@Qualifier("ModifyUid")MyService myService, MessageSender messageSender){
        this.myService=myService;
        this.messageSender = messageSender;
    }
    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback (@RequestBody Request request){
        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(request.getSystemTime())
                .code("success")
                .errorCode("")
                .errorMessage("")
                .build();
        Response afterModify = myService.execute(response);
        Response senderMessage = messageSender.send(afterModify);

//        RestTemplate restTemplate = new RestTemplate();
//        String url = "http://localhost:8080/feed";
//        restTemplate.postForLocation(url,afterModify);
        return new ResponseEntity<>(senderMessage, HttpStatus.OK);
    }
}
