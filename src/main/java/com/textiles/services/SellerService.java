package com.textiles.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.textiles.models.SellerModel;
import com.textiles.repositories.SellerRepository;

@RestController
@RequestMapping("sellers")
public class SellerService {
	
	@Autowired
	SellerRepository sellerRepository;

	@RequestMapping(value = "all", method = RequestMethod.GET)
	public List<SellerModel> getAllSellers(){
		return (List<SellerModel>) sellerRepository.findAll();
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public SellerModel addSeller(@RequestBody SellerModel seller){
		System.out.println(seller);
		return sellerRepository.save(seller);
	}
	
	@RequestMapping(value = "get", method = RequestMethod.GET)
	public SellerModel getSeller(){
		return SellerModel.builder().id(1l).firstName("Rohit").lastName("Mishra").build();
	}

}
