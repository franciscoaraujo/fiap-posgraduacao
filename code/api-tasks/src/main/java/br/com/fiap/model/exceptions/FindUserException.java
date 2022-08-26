package br.com.fiap.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FindUserException extends RuntimeException{

    public FindUserException(String msg, Long id){
        super(msg +"-"+ id);
    }
}
