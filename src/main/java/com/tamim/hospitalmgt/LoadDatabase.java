package com.tamim.hospitalmgt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
class LoadDatabase implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    PatientRepository patientRepository;
    DoctorRepository doctorRepository;

    @Autowired
    public LoadDatabase(PatientRepository pRep, DoctorRepository dRep) {
        this.doctorRepository = dRep;
        this.patientRepository = pRep;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

//        Patient patient = new Patient("Bilbo", "Baggins", "Sore Pussy");
//        log.info("Preloading " + patientRepository.save(patient));
//
//        Doctor doctor = new Doctor("Galadriel", "Junior", "Family");
//        log.info("Preloading " + doctorRepository.save(doctor));

    }
}