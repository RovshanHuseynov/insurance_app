package rovshan.insurance_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
//tell Spring Boot to respond with a 404 status when this exception is thrown
public class Exception extends RuntimeException{
    public Exception(){super();}
    public Exception(String error){
        super(error);
    }
}