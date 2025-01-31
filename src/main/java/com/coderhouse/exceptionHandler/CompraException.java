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

public class CompraException extends Exception implements Serializable {

    public CompraException(String message) {
        super(message);
    }
}