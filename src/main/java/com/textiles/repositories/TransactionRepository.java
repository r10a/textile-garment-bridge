package com.textiles.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.textiles.models.TransactionModel;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "transactions", path = "transactions")
public interface TransactionRepository extends CrudRepository<TransactionModel, Long>{

}
