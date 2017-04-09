package com.textiles.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.textiles.models.AdminModel;
import com.textiles.models.BuyerModel;

@RepositoryRestResource(collectionResourceRel = "admins", path = "admins")
public interface AdminRepository extends CrudRepository<AdminModel, Long>{
	
	List<BuyerModel> findByEmail(@Param("email") String email);

}
