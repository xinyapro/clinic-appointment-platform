package sg.com.xinyapro.clinic.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sg.com.xinyapro.clinic.dto.CreateDoctorRequest;
import sg.com.xinyapro.clinic.dto.DoctorResponse;
import sg.com.xinyapro.clinic.dto.UpdateDoctorRequest;
import sg.com.xinyapro.clinic.service.DoctorService;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<DoctorResponse> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public DoctorResponse getDoctorById(@PathVariable Integer id) {
        return doctorService.getDoctorById(id);
    }

    @PostMapping
    public ResponseEntity<DoctorResponse> createDoctor(
            @Valid @RequestBody CreateDoctorRequest request) {
        DoctorResponse createdDoctor = doctorService.createDoctor(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdDoctor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorResponse> updateDoctor(
            @PathVariable Integer id,
            @Valid @RequestBody UpdateDoctorRequest request) {
        DoctorResponse updatedDoctor = doctorService.updateDoctor(id, request);
        return ResponseEntity.ok(updatedDoctor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Integer id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}
