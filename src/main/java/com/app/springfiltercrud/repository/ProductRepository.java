package com.app.springfiltercrud.repository;

import com.app.springfiltercrud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT p FROM Product p WHERE p.name LIKE %:keyword% OR p.brand LIKE %:keyword% OR p.madeIn LIKE %:keyword%")
    List<Product> findAll(@Param("keyword") Optional<String> keyword);



}
