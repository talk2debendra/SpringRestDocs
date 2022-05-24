package com.deb.restdocs.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.deb.restdocs.model.Product;

@RestController("/v1")
public class ProductController {

	List<Product> products = Arrays.asList(new Product("SMG-TV", "Samsung TV"), new Product("LG", "LG-TV"),
			new Product("ONDA", "Onida-TV"));

	@GetMapping("/products/{code}")
	public Product getProduct(@PathVariable("code") String code) {
		return products.stream().filter(p -> p.getCode().equalsIgnoreCase(code))
				.findFirst().orElse(null);

	}
	@GetMapping("/products")
    public List<Product> getProducts(){
        return products;
    }
}
