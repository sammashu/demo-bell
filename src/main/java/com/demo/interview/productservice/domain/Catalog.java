package com.demo.interview.productservice.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
public class Catalog  implements Serializable{

	private static final long serialVersionUID = 7858150420053980570L;

	@Id
	private String codeCatalog;
	
	@Column
	private String name;
	
	public Catalog(String codeCatalog, String name) {
		this.codeCatalog = codeCatalog;
		this.name = name;
	}
	
	protected Catalog(){}

	public String getCodeCatalog() {
		return codeCatalog;
	}

	public void setCodeCatalog(String codeCatalog) {
		this.codeCatalog = codeCatalog;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		
		return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
				.append("codeCatalog", this.codeCatalog)
				.append("name", this.name)
				.build();

	}
	
	
	

}
