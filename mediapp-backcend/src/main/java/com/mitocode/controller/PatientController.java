package com.mitocode.controller;

import com.mitocode.dto.PatientDTO;
import com.mitocode.model.Patient;
import com.mitocode.service.IPatientService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientController {
    private final IPatientService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<PatientDTO>> findAll() throws Exception{
        List<PatientDTO> list = service.findAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
        //return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> findById(@PathVariable("id") Integer id) throws Exception {
        Patient obj= service.findById(id);
        return ResponseEntity.ok(convertToDto(obj));
    }
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody PatientDTO dto) throws Exception{
        Patient obj = service.save(convertToEntity(dto));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPatient()).toUri();

        //return new ResponseEntity<>(obj, HttpStatus.CREATED);
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> update(@PathVariable("id") Integer id, @RequestBody Patient patient) throws Exception {
        patient.setIdPatient(id);
        Patient obj = service.update(id,patient);
        return ResponseEntity.ok(convertToDto(obj));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    private PatientDTO convertToDto(Patient obj){
        return modelMapper.map(obj, PatientDTO.class);
    }

    private Patient convertToEntity(PatientDTO dto){
        return modelMapper.map(dto, Patient.class);
    }

}
