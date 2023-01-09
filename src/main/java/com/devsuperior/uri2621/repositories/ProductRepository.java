package com.devsuperior.uri2621.repositories;

import com.devsuperior.uri2621.dto.ProductMinDTO;
import com.devsuperior.uri2621.projections.ProductMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2621.entities.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(nativeQuery = true, value="SELECT pr.name " +
            "FROM PRODUCTS as pr INNER JOIN PROVIDERS as p ON " +
            "pr.id_providers = p.id " +
            "WHERE pr.amount BETWEEN :min and :max " +
            "AND p.name LIKE :providersChar%")
    List<ProductMinProjection> searchByProductNameAndProvidersWhereP(Integer min, Integer max, Character providersChar);

    @Query(value="SELECT new com.devsuperior.uri2621.dto.ProductMinDTO(pr.name)" +
            "FROM Product pr WHERE pr.amount BETWEEN :min and :max " +
            "AND pr.provider.name LIKE :providersChar%")
    List<ProductMinDTO> searchByProductNameAndProviders(Integer min, Integer max, Character providersChar);

}
