package ru.mukhametdinov.testrestlab.service;

import ru.mukhametdinov.testrestlab.model.Response;

public interface MessageSender {
    Response send(Response response);
}
