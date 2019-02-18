package com.gb.repositories;

import com.gb.entities.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    @PostConstruct
    public void init() {
        this.products = new ArrayList<>(Arrays.asList(new Product((long)1, "Apple", 500),
                new Product((long)2, "Samsung", 300)));
    }
}