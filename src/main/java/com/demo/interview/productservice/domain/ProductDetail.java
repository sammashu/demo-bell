package com.demo.interview.productservice.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
public class ProductDetail implements Serializable{
	
	private static final long serialVersionUID = -462140200794426881L;
	
	@Id
	@GeneratedValue
	private Long idProductDetail;
	@Column
	private String title;
	@Column
	private String description;
	@Column
	private Double price;
	
	@ManyToOne
	private Catalog catalog;
	
	public ProductDetail(String title, String description, Double price, Catalog catalog) {
		this.title = title;
		this.description = description;
		this.price = price;
		this.catalog = catalog;
	}
	
	protected ProductDetail(){}

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

	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
				.append("idProductDetail", this.idProductDetail)
				.append("title", this.title)
				.append("description", this.description)
				.append("price", this.price)
				.append("catalog", this.catalog)
				.build();
	}
	
	
	
	

}
