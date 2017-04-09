package com.textiles.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.textiles.models.SellerModel;

@RepositoryRestResource(collectionResourceRel = "sellers", path = "sellers")
public interface SellerRepository extends CrudRepository<SellerModel, Long>{

	List<SellerModel> findByEmail(@Param("email") String email);
	
	@Query("SELECT s FROM SellerModel as s LEFT JOIN FETCH s.rawMaterials LEFT JOIN FETCH s.yarns LEFT JOIN FETCH s.fabrics LEFT JOIN FETCH s.garments WHERE s.id = ?1")
	List<SellerModel> getAllInfo(@Param("id") Long id);
}
