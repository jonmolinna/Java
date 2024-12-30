package com.apirest.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.demo.Entities.Product;
import com.apirest.demo.Repositories.ProductRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();        
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found: " + id));
    }
    

    @PostMapping
    public Product addProduct(@RequestBody Product product) {        
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public Product updatedProduct(@PathVariable Long id, @RequestBody Product body) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found: " + id));
        
        product.setName(body.getName());
        product.setPrice(body.getPrice());

        return productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found: " + id));

        productRepository.delete(product);

        return "Product delete" + id;
    }
}
