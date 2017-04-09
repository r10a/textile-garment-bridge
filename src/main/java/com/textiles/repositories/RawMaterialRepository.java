package com.textiles.repositories;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "raw-materials", path = "raw-materials")
public interface RawMaterialRepository {

}
