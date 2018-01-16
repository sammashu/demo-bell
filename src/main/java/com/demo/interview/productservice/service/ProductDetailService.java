package com.demo.interview.productservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.interview.productservice.domain.Catalog;
import com.demo.interview.productservice.domain.ProductDetail;
import com.demo.interview.productservice.dto.ProductDetailDTO;
import com.demo.interview.productservice.repository.CatalogRepository;
import com.demo.interview.productservice.repository.ProductDetailRepository;

@Service
public class ProductDetailService {
	
	private CatalogRepository catalogRepo;
	private ProductDetailRepository productDetailRepo;
	
	@Autowired
	public ProductDetailService(CatalogRepository catalogRepo, ProductDetailRepository productDetailRepo) {
		this.catalogRepo = catalogRepo;
		this.productDetailRepo = productDetailRepo;
	}
	
	public ProductDetail createProductDetail(String title, String description, Double price, String codeCatalog){
		
		Catalog catalog = catalogRepo.findOne(codeCatalog);
		
		if(catalog == null){
			throw new RuntimeException("Catalog does not exist in the database: " + catalog);
		}
		
		return productDetailRepo.save(new ProductDetail(title, description, price, catalog));
	}
	
	public Iterable<ProductDetail> getAll(){
		return productDetailRepo.findAll();
	}
	
	public void deleteProductDetail(Long idProductDetail){	
		productDetailRepo.delete(idProductDetail);
	}
	
	public ProductDetail getOne(Long idProductDetail){
		return productDetailRepo.findOne(idProductDetail);
	}

	
	public ProductDetail updateProductDetail(Long idProductDetail, ProductDetailDTO productDetailDTO){
		ProductDetail productDetail = productDetailRepo.findOne(idProductDetail);
		
		if(productDetail == null){
			throw new RuntimeException("Product detail not exist un the database: " + productDetail);
		}
		
		productDetail.setTitle(productDetailDTO.getTitle());
		productDetail.setPrice(productDetailDTO.getPrice());
		
		Catalog catalog = catalogRepo.findOne(productDetailDTO.getCodeCatalog());
		
		if(catalog == null){
			throw new RuntimeException("Catalog does not exist in the database: " + catalog);
		}
		
		productDetail.setCatalog(catalog);
		productDetail.setDescription(productDetailDTO.getDescription());
		
		return productDetailRepo.save(productDetail);
	}
	

}
