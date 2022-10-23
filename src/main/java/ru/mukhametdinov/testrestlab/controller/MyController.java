package ru.mukhametdinov.testrestlab.controller;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.mukhametdinov.testrestlab.model.Request;
import ru.mukhametdinov.testrestlab.model.Response;
import ru.mukhametdinov.testrestlab.service.LogService;
import ru.mukhametdinov.testrestlab.service.MessageSender;
import ru.mukhametdinov.testrestlab.service.MyService;

@Slf4j
@RestController
public class MyController {
    private final MyService myService;
    private final MessageSender messageSender;

    private final Logger log = LoggerFactory.getLogger(MyController.class);
    private final LogService logService;

    @Autowired
    public MyController (@Qualifier("ModifyUid")MyService myService, MessageSender messageSender, LogService logService){
        this.myService=myService;
        this.messageSender = messageSender;
        this.logService = logService;
    }
    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback (@RequestBody Request request){

        log.info("Входящий request: "+String.valueOf(request));

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(request.getSystemTime())
                .code("success")
                .errorCode("")
                .errorMessage("")
                .build();
        Response afterModify = myService.execute(response);
        log.info("Исходящий response: "+String.valueOf(response));
        //Response senderMessage = messageSender.send(afterModify);

        //System.out.println(response.getUid());

        return new ResponseEntity<>(afterModify, HttpStatus.OK);
    }

}
