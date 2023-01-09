package com.devsuperior.uri2621;

import com.devsuperior.uri2621.dto.ProductMinDTO;
import com.devsuperior.uri2621.projections.ProductMinProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2621.repositories.ProductRepository;

import java.util.List;

@SpringBootApplication
public class Uri2621Application implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2621Application.class, args);
	}

	@Autowired
	private ProductRepository productRepository;
	@Override
	public void run(String... args) throws Exception {
		List<ProductMinProjection> namesProduct = productRepository.searchByProductNameAndProvidersWhereP(10,  20, 'P');
		namesProduct.stream().map(x -> x.getName()).forEach(System.out::println);

		List<ProductMinDTO> name = productRepository.searchByProductNameAndProviders(10, 20, 'P');
		name.stream().map(x -> x.getName()).forEach(System.out::println);

	}
}
