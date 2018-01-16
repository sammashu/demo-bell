package com.demo.interview.productservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.interview.productservice.domain.ProductDetail;
import com.demo.interview.productservice.dto.ProductDetailDTO;
import com.demo.interview.productservice.service.ProductDetailService;
import com.google.common.collect.Lists;

@RestController
@RequestMapping(path = "/api/v1/product")
public class ProductDetailController {
	
	private ProductDetailService productDetailService;

	@Autowired
	public ProductDetailController(ProductDetailService productDetailService) {
		this.productDetailService = productDetailService;
	}
	
	
	@PostMapping(path = "/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createProductDetail(@RequestBody @Validated ProductDetailDTO productDetailDto){
		
		productDetailService.createProductDetail(productDetailDto.getTitle(), productDetailDto.getDescription(), productDetailDto.getPrice(), productDetailDto.getCodeCatalog());
		
	}
	
	@GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDetailDTO> findAllProductDetail(){
		final List<ProductDetail> lstProductDetail =  Lists.newArrayList(productDetailService.getAll());
		return convertListProductDetailToDTO(lstProductDetail);
	}
	
	@DeleteMapping(path = "/delete/{idProductDetail}")
	public void deleteProductDetail(@PathVariable(value="idProductDetail") Long idProductDetail){
		productDetailService.deleteProductDetail(idProductDetail);
	}
	
	@GetMapping(path = "/{idProductDetail}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductDetailDTO getOneProductDetail(@PathVariable(value="idProductDetail") Long idProductDetail){
		return convertProductDetailToDTO(productDetailService.getOne(idProductDetail));
	}
	
	
	@PutMapping
	public ProductDetailDTO updateProductDetail(@PathVariable(value = "idProductDetail") Long idProductDetail, @RequestBody ProductDetailDTO productDetailDTO){
		return convertProductDetailToDTO(productDetailService.updateProductDetail(idProductDetail, productDetailDTO));
	}
	
	private List<ProductDetailDTO> convertListProductDetailToDTO(List<ProductDetail> lstProductDetail){
		
		final List<ProductDetailDTO> lstProductDetailDTO = new ArrayList<>();
		for(ProductDetail p: lstProductDetail){
			ProductDetailDTO pdd = new ProductDetailDTO();
			pdd.setIdProductDetail(p.getIdProductDetail());
			pdd.setTitle(p.getTitle());
			pdd.setDescription(p.getDescription());
			pdd.setPrice(p.getPrice());
			pdd.setCodeCatalog(p.getCatalog().getCodeCatalog());
			lstProductDetailDTO.add(pdd);
		}
		
		return lstProductDetailDTO;
	}
	
	private ProductDetailDTO convertProductDetailToDTO(ProductDetail p){
		ProductDetailDTO pdd = new ProductDetailDTO();
		pdd.setIdProductDetail(p.getIdProductDetail());
		pdd.setTitle(p.getTitle());
		pdd.setDescription(p.getDescription());
		pdd.setPrice(p.getPrice());
		pdd.setCodeCatalog(p.getCatalog().getCodeCatalog());
		
		return pdd;
	}
}
