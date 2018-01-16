package com.demo.interview.productservice.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.demo.interview.productservice.domain.ProductDetail;
import com.demo.interview.productservice.repository.ProductDetailRepository;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class CartService {
	
	private ProductDetailRepository productDetailRepo;
	
	private Map<Long, ProductDetail> products = new HashMap<>();

	@Autowired
	public CartService(ProductDetailRepository productDetailRepo) {
		this.productDetailRepo = productDetailRepo;
	}
	
    public void addProduct(Long idProductDetail) { 	
    	ProductDetail product = productDetailRepo.findOne(idProductDetail);  	
        if (!products.containsKey(idProductDetail)) {
        	products.put(idProductDetail, product);
        }
    }



    public void removeProduct(Long idProductDetail) {
    	ProductDetail product = productDetailRepo.findOne(idProductDetail);  
        if (products.containsKey(idProductDetail)) {
              products.remove(idProductDetail);
        }
    }
    
    public Map<Long, ProductDetail> getProductsInCart() {
        return Collections.unmodifiableMap(products);
    }


}
