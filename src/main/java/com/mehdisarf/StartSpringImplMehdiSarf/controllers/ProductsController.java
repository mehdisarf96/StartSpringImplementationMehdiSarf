package com.mehdisarf.StartSpringImplMehdiSarf.controllers;

import com.mehdisarf.StartSpringImplMehdiSarf.model.Product;
import com.mehdisarf.StartSpringImplMehdiSarf.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductsController {

    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/products")
    public String viewProducts(Model model) {

        // get the product list from the service.
        List<Product> products = productService.findAll();

        model.addAttribute("products", products);

        return "products.html";
    }

    // same path but with different method.
    // mitunesti @PostMapping ham bezari.
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String addProduct(@RequestParam String name,
                             @RequestParam double price,
                             Model model) {

        // build a new instance and add it to the list by calling the service use case method.
        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setPrice(price);
        productService.addProduct(newProduct);

        List<Product> products = productService.findAll();
        model.addAttribute("products", products);

        return "products.html";
    }
}
