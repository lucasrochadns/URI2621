package com.devsuperior.uri2621.dto;

import com.devsuperior.uri2621.projections.ProductMinProjection;

import java.io.Serializable;

public class ProductMinDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    public ProductMinDTO(String name) {
        this.name = name;
    }
    public ProductMinDTO(ProductMinProjection projection){
        this.name = projection.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
