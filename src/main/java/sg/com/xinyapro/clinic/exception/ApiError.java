package sg.com.xinyapro.clinic.exception;


public record ApiError(
        String code,
        String message
) {
}
