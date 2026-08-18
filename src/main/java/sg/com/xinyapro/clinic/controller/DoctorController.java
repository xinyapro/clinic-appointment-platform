package sg.com.xinyapro.clinic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sg.com.xinyapro.clinic.entity.Doctor;
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
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Integer id) {
        return doctorService.getDoctorById(id);
    }

    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        Doctor createdDoctor = doctorService.createDoctor(doctor);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdDoctor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(
            @PathVariable Integer id,
            @RequestBody Doctor doctor) {
        Doctor updatedDoctor = doctorService.updateDoctor(id, doctor);
        return ResponseEntity.ok(updatedDoctor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Integer id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}
