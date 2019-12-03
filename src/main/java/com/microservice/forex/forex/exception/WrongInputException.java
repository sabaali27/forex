package com.microservice.forex.forex.exception;

public class WrongInputException extends Exception {
    public WrongInputException()
    {
        super("To and From value is not present in the database!");
    }

}
