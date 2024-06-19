package nina.isaeva.org.workingtimepraktika.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException() {
    }

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}