package com.textiles.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.textiles.models.FabricModel;

@RepositoryRestResource(collectionResourceRel = "fabrics", path = "fabrics")
public interface FabricRepository extends CrudRepository<FabricModel, Long>{

}
