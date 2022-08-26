package br.com.fiap.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FindUserTaskException extends RuntimeException{

    public FindUserTaskException(String msg, Long id){
        super(msg +": "+ id);
    }
}
