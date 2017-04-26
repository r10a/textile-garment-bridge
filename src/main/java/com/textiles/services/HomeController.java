package com.textiles.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.textiles.models.FabricModel;
import com.textiles.models.GarmentModel;
import com.textiles.models.RawMaterialModel;
import com.textiles.models.YarnModel;
import com.textiles.repositories.FabricRepository;
import com.textiles.repositories.GarmentRepository;
import com.textiles.repositories.RawMaterialRepository;
import com.textiles.repositories.YarnRepository;

@Controller
public class HomeController {
	
	@Autowired
	FabricRepository fabricRepository;
	
	@Autowired
	GarmentRepository garmentRepository;
	
	@Autowired
	YarnRepository yarnRepository;
	
	@Autowired
	RawMaterialRepository rawMaterialRepository;
	
	@RequestMapping("/")
	public String home() {
		addFabric();
		addGarment();
		addRawMaterial();
		addYarn();
		return "index.html";
	}
	
	private void addFabric(){
		FabricModel fabric = new FabricModel();
		fabric.setName("Fabric 1");
		fabric.setPrice(400D);
		fabric.setLength(3D);
		fabric.setWeaveType("Weave Type 1");
		fabric.setWidth(4D);
		fabric.setYarnType("Yarn Type 1");
		fabricRepository.save(fabric);
	}
	
	private void addGarment(){
		GarmentModel garment = new GarmentModel();
		garment.setName("Garment 1");
		garment.setPrice(400D);
		garment.setQuantity(4L);
		garment.setSize("6");
		garment.setSpecification("Specification 1");
		garmentRepository.save(garment);
	}
	
	private void addYarn(){
		YarnModel yarn = new YarnModel();
		yarn.setName("Yarn 1");
		yarn.setPrice(400D);
		yarn.setLength(6D);
		yarn.setPercentage(50D);
		yarn.setTicket(12345l);
		yarnRepository.save(yarn);
	}
	
	private void addRawMaterial(){
		RawMaterialModel material = new RawMaterialModel();
		material.setName("Raw Material 1");
		material.setPrice(400D);
		material.setNature("Nature 1");
		material.setWeight(45D);
		rawMaterialRepository.save(material);
	}

}