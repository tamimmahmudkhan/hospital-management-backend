package com.tamim.hospitalmgt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class HospitalRESTController {

    private final PatientRepository patientRepository;
    private final MedicineRepository medicineRepository;
    private final DoctorRepository doctorRepository;
    private final EquipmentRepository equipmentRepository;
    private  final AdminRepository adminRepository;

    @Autowired
    public HospitalRESTController(PatientRepository patientRepository, DoctorRepository doctorRepository, MedicineRepository medicineRepository, EquipmentRepository equipmentRepository, AdminRepository adminRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.medicineRepository = medicineRepository;
        this.equipmentRepository = equipmentRepository;
        this.adminRepository = adminRepository;
    }

    @GetMapping("/patients")
    public List<Patient> getPatients(){
        return patientRepository.findAll();
    }

    @PostMapping("/new/patient")
    public Patient newPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @PostMapping("/new/doctor")
    public Doctor newDoctor(@RequestBody Doctor doctor){
        return doctorRepository.save(doctor);
    }

    @GetMapping("/doctors")
    public List<Doctor> getDoctors(){
        return doctorRepository.findAll();
    }

    @GetMapping("/medicines")
    public List<Medicine> getMedicine(){
        return medicineRepository.findAll();
    }

    @GetMapping("/equipments")
    public List<Equipment> getEquipment(){
        return equipmentRepository.findAll();
    }

    @PostMapping(value = "/login/{username}/{password}")
    public Admin isAdmin(@PathVariable String username, @PathVariable String password){
        return adminRepository.findByUname(username);
    }

    @GetMapping("/count/patients")
    long getPatientCount(){ return patientRepository.count();}
    @GetMapping("/count/doctors")
    long getDoctorCount(){ return doctorRepository.count();}
    @GetMapping("/count/medicines")
    long getMedicineCount(){ return medicineRepository.count();}
    @GetMapping("/count/equipents")
    long getEquipentCount(){ return equipmentRepository.count();}

}
