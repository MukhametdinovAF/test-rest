package ru.mukhametdinov.testrestlab.service;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class CreateLog implements LogService{

    @Override
    public void createLog(Logger logger) {
        logger.info("Cообщение получено и обработано!");
    }
}
