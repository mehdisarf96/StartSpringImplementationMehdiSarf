package com.mehdisarf.StartSpringImplMehdiSarf.services;

import com.mehdisarf.StartSpringImplMehdiSarf.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();

    // First usecase
    public void addProduct(Product product) {
        products.add(product);
    }

    // Second usecase
    public List<Product> findAll() {
        return products;
    }
}
