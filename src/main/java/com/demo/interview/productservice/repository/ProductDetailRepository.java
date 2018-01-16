package com.demo.interview.productservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.interview.productservice.domain.ProductDetail;

public interface ProductDetailRepository extends CrudRepository<ProductDetail, Long>{


}
