package com.microservice.forex.forex.controller;

import com.microservice.forex.forex.JPARepository.ExchangeValueRepository;
import com.microservice.forex.forex.bean.ExchangeValue;
import com.microservice.forex.forex.exception.WrongInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;


@RestController
public class ForexController {

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue
            (@PathVariable String from, @PathVariable String to) throws WrongInputException {

        ExchangeValue exchangeValue =
                repository.findByFromAndTo(from, to);

     if(exchangeValue != null) {
         exchangeValue.setPort(
                 Integer.parseInt(environment.getProperty("local.server.port")));
     }

        else
        {
            throw new WrongInputException();
        }
        return exchangeValue;
    }
}
