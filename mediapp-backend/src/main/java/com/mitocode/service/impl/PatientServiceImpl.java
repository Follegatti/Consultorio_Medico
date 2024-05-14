package com.mitocode.service.impl;

import com.mitocode.model.Patient;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IPatientRepo;
import com.mitocode.service.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl extends CRUDImpl<Patient, Integer> implements IPatientService {

    //@Autowired
    private final IPatientRepo repo;

    @Override
    protected IGenericRepo<Patient, Integer> getRepo() {
        return repo;
    }

    /*@Override
    public Patient save(Patient patient) throws Exception {
        return repo.save(patient);
    }

    @Override
    public Patient update(Integer id, Patient patient) throws Exception {
        //Falta agregar validacion del ID
        return repo.save(patient);
    }

    @Override
    public List<Patient> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Patient findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Patient());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }*/

    //@Autowired
    /*public PatientService(PatientRepo repo) {
        this.repo = repo;
    }*/

    /*@Override
    public Patient sayHelloAndValid(Patient patient) {
        //repo = new PatientRepo();
        if (patient.getIdPatient() >= 1) {
            return repo.sayHello(patient);
        } else {
            return new Patient();
        }
    }*/
}
