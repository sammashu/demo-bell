package com.demo.interview.productservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.interview.productservice.domain.Catalog;
import com.demo.interview.productservice.dto.CatalogDTO;
import com.demo.interview.productservice.service.CatalogService;
import com.google.common.collect.Lists;

@RestController
@RequestMapping(path = "/api/v1/catalog")
public class CatalogController {
	
	private CatalogService catalogService;

	@Autowired
	public CatalogController(CatalogService catalogService) {
		this.catalogService = catalogService;
	}
	
	@GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CatalogDTO> getAllCatalog(){
		List<Catalog> lstCatalog = Lists.newArrayList(catalogService.getAll());
		return convertListCatalogToDTO(lstCatalog);
	}
	
	private List<CatalogDTO> convertListCatalogToDTO(List<Catalog> lstCatalog){
		List<CatalogDTO> lstCatalogDTO = new ArrayList<>();
		for(Catalog c : lstCatalog){
			CatalogDTO cDTO = new CatalogDTO();
			cDTO.setCodeCatalog(c.getCodeCatalog());
			cDTO.setName(c.getName());
			lstCatalogDTO.add(cDTO);
		}	
		return lstCatalogDTO;
	}

}
