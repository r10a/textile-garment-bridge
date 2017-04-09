package com.textiles.repositories;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "fabrics", path = "fabrics")
public interface FabricRepository {

}
