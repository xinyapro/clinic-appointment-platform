package sg.com.xinyapro.clinic.service;

import org.springframework.stereotype.Service;
import sg.com.xinyapro.clinic.entity.Doctor;
import sg.com.xinyapro.clinic.exception.DoctorNotFoundException;

import java.util.List;

@Service
public class DoctorService {

    public List<Doctor> getAllDoctors(){

        return List.of(
                new Doctor("Tom", "Cardiology"),
                new Doctor("Alice", "Dermatology"),
                new Doctor("David", "Orthopedics")
        );
    }

        /**
         * 这里List.of(...)是Java9 引入的方法，
         * 作用：快速创建一个不可修改的List

        return List.of(
                "Tom",
                "Alice",
                "David"
        );*/

   public  Doctor getDoctorById(Integer id){

       if (id == 1) {
           return new Doctor("Tom", "Cardiology");
       }
       if (id == 2) {
           return new Doctor("Alice", "Dermatology");
       }
       if (id == 3) {
           return new Doctor("David", "Orthopedics");
       }
       throw new DoctorNotFoundException(id);
   }

    public Doctor createDoctor(Doctor doctor) {
        return doctor;
    }

    public Doctor updateDoctor(Integer id, Doctor doctor) {
        getDoctorById(id);
        return doctor;
    }

    public void deleteDoctor(Integer id) {
        getDoctorById(id);
    }
}
