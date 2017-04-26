package com.textiles.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.textiles.models.GarmentModel;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "garments", path = "garments")
public interface GarmentRepository extends CrudRepository<GarmentModel, Long>{

}
