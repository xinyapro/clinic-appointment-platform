package sg.com.xinyapro.clinic.service;

import org.springframework.stereotype.Service;
import sg.com.xinyapro.clinic.dto.CreateDoctorRequest;
import sg.com.xinyapro.clinic.dto.DoctorResponse;
import sg.com.xinyapro.clinic.dto.UpdateDoctorRequest;
import sg.com.xinyapro.clinic.entity.Doctor;
import sg.com.xinyapro.clinic.exception.DoctorNotFoundException;

import java.util.List;

@Service
public class DoctorService {

    public List<DoctorResponse> getAllDoctors(){

        return List.of(
                new DoctorResponse("Tom", "Cardiology"),
                new DoctorResponse("Alice", "Dermatology"),
                new DoctorResponse("David", "Orthopedics")
        );
    }

   public  DoctorResponse getDoctorById(Integer id){

       if (id == 1) {
           return new DoctorResponse("Tom", "Cardiology");
       }
       if (id == 2) {
           return new DoctorResponse("Alice", "Dermatology");
       }
       if (id == 3) {
           return new DoctorResponse("David", "Orthopedics");
       }
       throw new DoctorNotFoundException(id);
   }

    public DoctorResponse createDoctor(CreateDoctorRequest request) {
       Doctor doctor = new Doctor(
               request.name(),
               request.department()
       );
       return new DoctorResponse(
               doctor.getName(),
               doctor.getDepartment()
       );
    }

    public DoctorResponse updateDoctor(Integer id, UpdateDoctorRequest request) {
        getDoctorById(id);
        return new DoctorResponse(request.name(), request.department());
    }

    public void deleteDoctor(Integer id) {
        getDoctorById(id);
    }
}
