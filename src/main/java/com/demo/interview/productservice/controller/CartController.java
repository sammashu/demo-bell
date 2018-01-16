package com.demo.interview.productservice.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.interview.productservice.domain.ProductDetail;
import com.demo.interview.productservice.service.CartService;

@RestController
@RequestMapping(path = "/api/v1/cart")
public class CartController {
	
	private CartService cartService;

	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}
	
	
    @GetMapping("/current")
    public Map<Long, ProductDetail> myCart() {
    	return cartService.getProductsInCart();
    }

    @GetMapping("/addProduct/{idProductDetail}")
    public Map<Long, ProductDetail> addProductToCart(@PathVariable("idProductDetail") Long idProductDetail) {
    	cartService.addProduct(idProductDetail);
        return myCart();
    }

    @GetMapping("/removeProduct/{idProductDetail}")
    public Map<Long, ProductDetail> removeProductFromCart(@PathVariable("idProductDetail") Long idProductDetail) {
    	cartService.removeProduct(idProductDetail);
        return myCart();
    }


	
}
