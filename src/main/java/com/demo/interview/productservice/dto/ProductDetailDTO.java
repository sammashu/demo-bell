package com.demo.interview.productservice.dto;



import javax.validation.constraints.NotNull;

public class ProductDetailDTO {
	
	private Long idProductDetail;
	
	@NotNull
	private String title;

	private String description;

	@NotNull
	private Double price;
	
	@NotNull
	private String codeCatalog;
	
	public ProductDetailDTO(){}
	

	public Long getIdProductDetail() {
		return idProductDetail;
	}


	public void setIdProductDetail(Long idProductDetail) {
		this.idProductDetail = idProductDetail;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCodeCatalog() {
		return codeCatalog;
	}

	public void setCodeCatalog(String codeCatalog) {
		this.codeCatalog = codeCatalog;
	}


}
