package com.starAndShadow.may.sakila.exception;


import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resourceName, String fieldName, @Nullable Object fieldValue) {
        super(String.format("No %s found with %s : '%s'", resourceName, fieldName, fieldValue));
    }
}

