package com.gb.controllers;

import com.gb.entities.Product;
import com.gb.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Welcome in our shop");
        List<Product> products = productService.getAllProducts();
        model.addAttribute("productsList", products);
        Product product = new Product();
        model.addAttribute("product", product);
        return "index";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Product getProductById(@PathVariable("id") Long id){
        Product product = productService.getProductById(id);
        return product;
    }

    @RequestMapping("/addProduct")
    public String addProduct(@ModelAttribute("product") Product product){
        productService.addProduct(product);
        return "redirect:/";
    }
}
