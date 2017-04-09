package com.textiles.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.textiles.models.BuyerModel;

@RepositoryRestResource(collectionResourceRel = "buyers", path = "buyers")
public interface BuyerRepository extends CrudRepository<BuyerModel, Long>{
	
	List<BuyerModel> findByEmail(@Param("email") String email);

}
	