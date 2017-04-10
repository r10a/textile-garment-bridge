package com.textiles.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.textiles.models.RawMaterialModel;

@RepositoryRestResource(collectionResourceRel = "raw-materials", path = "raw-materials")
public interface RawMaterialRepository extends CrudRepository<RawMaterialModel, Long>{

}
