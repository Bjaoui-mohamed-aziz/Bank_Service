package tn.iteam.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RessourceNotFoundException extends RuntimeException{

    public RessourceNotFoundException(String RessourceName, String fieldName, String fieldValue){

        super(String.format("Resource %s not found for field %s and value %s",
                RessourceName, fieldName, fieldValue));
    }

    }

