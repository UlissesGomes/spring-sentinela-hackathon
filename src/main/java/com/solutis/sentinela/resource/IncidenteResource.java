package com.solutis.sentinela.resource;


import com.solutis.sentinela.model.Incidente;
import com.solutis.sentinela.service.IncidenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IncidenteResource {

    @Autowired
    private IncidenteService service;

    @GetMapping("/incidentes")
    public ResponseEntity<List<Incidente>> incidentes() {
        return ResponseEntity.ok().body(service.allIncidentes());
    }

}
