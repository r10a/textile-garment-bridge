package com.textiles.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.textiles.models.RawMaterialModel;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "raw-materials", path = "raw-materials")
public interface RawMaterialRepository extends CrudRepository<RawMaterialModel, Long>{

}
