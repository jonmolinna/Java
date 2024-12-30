package com.apirest.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.demo.Entities.Product;

// <name entities = product, id entities product = Long>
public interface ProductRepository extends JpaRepository <Product, Long> {}
