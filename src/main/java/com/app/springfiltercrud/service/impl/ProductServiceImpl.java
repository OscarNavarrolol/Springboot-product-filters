package com.app.springfiltercrud.service.impl;

import com.app.springfiltercrud.entity.Product;
import com.app.springfiltercrud.repository.ProductRepository;
import com.app.springfiltercrud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> getAllProducts(String keyword) {
        Optional<String> optionalKeyword = Optional.ofNullable(keyword);
        if (optionalKeyword.isPresent()) {
            return productRepository.findAll(optionalKeyword);
        }
        return productRepository.findAll();
    }


    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product productExist = productRepository.findById(id).orElse(null);
        if (productExist != null){
            productExist.setName(product.getName());
            productExist.setBrand(product.getBrand());
            productExist.setMadeIn(product.getMadeIn());
            productExist.setPrice(product.getPrice());
            productRepository.save(productExist);
        }
        return null;
    }
}
