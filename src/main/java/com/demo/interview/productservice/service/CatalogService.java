package com.demo.interview.productservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.interview.productservice.domain.Catalog;
import com.demo.interview.productservice.repository.CatalogRepository;

@Service
public class CatalogService {
	
	private CatalogRepository catalogRepo;

	@Autowired
	public CatalogService(CatalogRepository catalogRepo) {
		this.catalogRepo = catalogRepo;
	}
	
	
	public Catalog createCatalog(String codeCatalog, String name){
		if(!catalogRepo.exists(codeCatalog)){
			catalogRepo.save(new Catalog(codeCatalog, name));
		}
		
		return null;
	}
	
	public Iterable<Catalog> getAll(){
		return catalogRepo.findAll();
	}
	
	public Catalog findById(String codeCatalog){
		return catalogRepo.findOne(codeCatalog);
	}
}
