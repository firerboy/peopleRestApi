package ru.lysenko.restapijpa.util;

public class PersonNotDeleteException extends RuntimeException{
    public PersonNotDeleteException(String msg){
        super(msg);
    }
}
