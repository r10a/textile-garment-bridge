package com.textiles.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.textiles.models.AdminModel;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "admins", path = "admins")
public interface AdminRepository extends CrudRepository<AdminModel, String>{

}
