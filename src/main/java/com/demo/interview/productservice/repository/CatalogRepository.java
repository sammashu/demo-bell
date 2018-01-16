package com.demo.interview.productservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.interview.productservice.domain.Catalog;

public interface CatalogRepository extends CrudRepository<Catalog, String> {


}
