package ru.mukhametdinov.testrestlab.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.mukhametdinov.testrestlab.model.Response;
@Service
@Qualifier("ModifyUid")
public class ModifyUid implements MyService{
    @Override
    public Response execute(Response response) {
        response.setUid("Успешно поменяли UID");
        return response;
    }
}
