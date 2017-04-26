package com.textiles.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.textiles.models.FabricModel;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "fabrics", path = "fabrics")
public interface FabricRepository extends CrudRepository<FabricModel, Long>{

}
