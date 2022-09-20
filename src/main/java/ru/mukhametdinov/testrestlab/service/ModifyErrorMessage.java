package ru.mukhametdinov.testrestlab.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.mukhametdinov.testrestlab.model.Response;
@Service
@Qualifier("ModifyErrorMessage")
public class ModifyErrorMessage implements MyService{
    @Override
    public Response execute(Response response) {
       response.setErrorMessage("Все плохо!");
        return response;
    }
}
