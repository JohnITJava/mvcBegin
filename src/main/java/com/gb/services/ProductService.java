package com.gb.services;

import com.gb.entities.Product;
import com.gb.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    Long id;

    public List<Product> getAllProducts() {
        return productRepository.getProducts();
    }

    public Product getProductById(Long id) {
        List<Product> products = getAllProducts();

        for (Product product : products) {
            if (product.getId() == id) return product;
        }
        return null;
    }

    public Product addProduct(Product product){
        id = (long)productRepository.getProducts().size();
        product.setId(++id);
        productRepository.getProducts().add(product);
        return product;
    }

}
