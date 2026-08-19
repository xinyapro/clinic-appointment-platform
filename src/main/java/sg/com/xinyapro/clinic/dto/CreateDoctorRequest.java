package sg.com.xinyapro.clinic.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateDoctorRequest(

        @NotBlank(message = "Doctor Name is required")
        @Size(max = 100, message = "Doctor name must not exceed 100 characters")
        String name,

        @NotBlank(message = "Department is required")
        @Size(max = 100, message = "Department must not exceed 100 characters")
        String department
) {
}
