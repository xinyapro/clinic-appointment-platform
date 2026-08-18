package sg.com.xinyapro.clinic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<ApiError> handleDoctorNotFound(
            DoctorNotFoundException exception){
        ApiError error = new ApiError(
                "DOCTOR_NOT_FOUND",
                exception.getMessage()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);

    }
}
