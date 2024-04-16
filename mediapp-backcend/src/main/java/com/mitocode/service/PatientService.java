package com.mitocode.service;

import com.mitocode.model.Patient;
import com.mitocode.repo.IPatientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService implements IPatientService{
    private final IPatientRepo repo;

    @Override
    public Patient save(Patient patient) throws Exception {
        return repo.save(patient);
    }

    @Override
    public Patient update(Integer id, Patient patient) throws Exception {
        //falta agregar validacion
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
    }
}
