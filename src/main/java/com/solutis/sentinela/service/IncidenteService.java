package com.solutis.sentinela.service;

import com.solutis.sentinela.model.Incidente;
import com.solutis.sentinela.repository.IncidenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidenteService {

    @Autowired
    private IncidenteRepository incidenteRepository;

    public List<Incidente> allIncidentes(){
        return  incidenteRepository.findAll();
    }

}
