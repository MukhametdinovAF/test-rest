package ru.mukhametdinov.testrestlab.service;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class CreateLog implements LogService{

    @Override
    public void createLog(Logger logger) {
        logger.trace("This is TRACE");
        logger.debug("This is DEBUG");
        logger.info("This is INFO");
        logger.warn("This is WARN");
        logger.error("This is ERROR");
    }
}
