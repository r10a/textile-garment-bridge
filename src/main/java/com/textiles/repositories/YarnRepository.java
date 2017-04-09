package com.textiles.repositories;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "yarns", path = "yarns")
public interface YarnRepository {

}
