package com.demo.interview.productservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket swaggerCart() {
	    return new Docket(DocumentationType.SWAGGER_2)
	    		.select()
	    		.apis(RequestHandlerSelectors.basePackage("com.demo.interview.productservice.controller"))
	    		.build()
	    		.apiInfo(apiInfo());
	}

	
	

	private ApiInfo apiInfo() {
	    return new ApiInfoBuilder()
	            .title("DEMO CART")
	            .description("DEMO CART")
	            .termsOfServiceUrl("http://springfox.io")
	            .license("Apache License Version 2.0")
	            .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
	            .version("1.0")
	            .build();
	}
}
