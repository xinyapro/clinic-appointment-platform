package sg.com.xinyapro.clinic.exception;

public class DoctorNotFoundException extends RuntimeException {

    public DoctorNotFoundException(Integer id) {
        super("Doctor " + id + " was not found");
    }

}
