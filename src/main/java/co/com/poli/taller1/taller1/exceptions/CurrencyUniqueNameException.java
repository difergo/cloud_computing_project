package co.com.poli.taller1.taller1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CurrencyUniqueNameException extends RuntimeException {
    public CurrencyUniqueNameException(String message) {
        super(message);
    }

}
