package com.coderhouse.exceptionHandler;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.aot.hint.annotation.RegisterReflection;



@Getter
@Setter
@NoArgsConstructor
@ToString
@RegisterReflection

public class AsignacionDeCategoriaException extends Exception implements Serializable {

    public AsignacionDeCategoriaException(String message) {
        super(message);
    }
}