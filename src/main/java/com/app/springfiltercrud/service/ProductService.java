package com.app.springfiltercrud.service;

import com.app.springfiltercrud.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts(String keyWord);
    public Product saveProduct (Product product);

    public Product getProductById(Long id);

    public void deleteProduct(Long id);

    public Product updateProduct(Long id,Product product);

}
