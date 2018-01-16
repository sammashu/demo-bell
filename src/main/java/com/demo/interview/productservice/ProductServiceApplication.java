package com.demo.interview.productservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.interview.productservice.service.CatalogService;
import com.demo.interview.productservice.service.ProductDetailService;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner{
	
	public static Logger LOGGER = LoggerFactory.getLogger(ProductServiceApplication.class);
	
	@Autowired
	private CatalogService catalogService;
	@Autowired
	private ProductDetailService productDetailService;
	

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}


	@Override
	public void run(String... arg0) throws Exception {
	
		catalogService.createCatalog("CE", "Comedie");
		catalogService.createCatalog("AC", "Action");
		catalogService.createCatalog("SP", "Sport");
		catalogService.createCatalog("SC", "Sience-fiction");
		catalogService.createCatalog("AV", "Adventure");
		catalogService.createCatalog("DR", "Drama");
		catalogService.createCatalog("HR", "Horror");
		
		catalogService.getAll().forEach(catalog -> LOGGER.info(catalog.toString()));
		
		
		productDetailService.createProductDetail("E.T. THE EXTRA-TERRESTRIAL","classic movie for kids", 19.99, "SC");
		productDetailService.createProductDetail("ALIEN"," Alien blends science fiction", 19.99, "HR");
		productDetailService.createProductDetail("SEVEN SAMURAI","The Seven Samurai is an epic adventure classic", 19.99, "AC");
		productDetailService.createProductDetail("THE SEARCHERS","John Wayne Western that introduces dark ambivalence", 19.99, "AV");
		productDetailService.createProductDetail("SUPERBAD","Deftly balancing vulgarity and sincerity ", 19.99, "CE");
		productDetailService.createProductDetail("ENTER THE DRAGON","Bruce lee", 19.99, "SP");
		productDetailService.createProductDetail("LOVE AND BASKETBALL"," A young African-American couple navigates the tricky paths", 19.99, "DR");
		
		productDetailService.getAll().forEach(productDetail -> LOGGER.info(productDetail.toString()));
	}
}
