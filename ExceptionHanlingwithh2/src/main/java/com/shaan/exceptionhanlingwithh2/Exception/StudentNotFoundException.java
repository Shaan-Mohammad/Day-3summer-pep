package com.shaan.exceptionhanlingwithh2.Exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String message) {
        super(message);
    }
}   