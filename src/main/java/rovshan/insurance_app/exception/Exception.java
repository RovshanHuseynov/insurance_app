package rovshan.insurance_app.exception;

public class Exception extends RuntimeException{
    public Exception(){super();}
    public Exception(String error){
        super(error);
    }
}