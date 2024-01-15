package com.app.springfiltercrud.repository;

import com.app.springfiltercrud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product,Long> {

}
