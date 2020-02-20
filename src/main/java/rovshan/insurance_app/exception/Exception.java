package rovshan.insurance_app.exception;

import javassist.NotFoundException;

public class Exception {
    public void callException(String exception) throws NotFoundException {
        throw new NotFoundException(exception);
    }
}