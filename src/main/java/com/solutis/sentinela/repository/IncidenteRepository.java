package com.solutis.sentinela.repository;

import com.solutis.sentinela.model.Incidente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IncidenteRepository extends MongoRepository<Incidente,String> {
}
