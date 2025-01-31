package com.coderhouse.exceptionHandler;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class VentaException extends Exception implements Serializable {
    public VentaException(String message) {
        super(message);
    }
}