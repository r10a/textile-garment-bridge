package com.textiles.repositories;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "garments", path = "garments")
public interface GarmentRepository {

}
